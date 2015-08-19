package api;

import api.annotations.GET;
import api.annotations.Query;
import base.Account;
import base.CFResponse;
import com.google.gson.Gson;
import core.ServiceHolder;
import javafx.util.Pair;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CFHandler implements InvocationHandler {
    private final Map<Method, String[]> knownMethodKeys = new HashMap<>();
    private final long CF_COOLDOWN = 300;
    private CompletableFuture<Void> sleeper;

    @Override
    public Object invoke(Object proxy, Method method, Object[] argValues) throws Throwable {
        String apiMethodName = method.getAnnotation(GET.class).value();
        String[] keys = knownMethodKeys.computeIfAbsent(method, this::getQueryKeys);
        String fullQuery = generateQuery(apiMethodName, keys, argValues);

        if (fullQuery != null) {
            trySleep();
            String jsonResponse = sendQuery(fullQuery);
            return new Gson().fromJson(jsonResponse, method.getGenericReturnType());
        }

        return null;
    }

    private String[] getQueryKeys(Method method) {
        return Arrays.stream(method.getParameterAnnotations())
                .map(annotations -> Arrays.stream(annotations).filter(annotation -> annotation.annotationType() == Query.class).findAny().get())
                .map(annotation -> (Query) annotation)
                .map(Query::value)
                .toArray(String[]::new);
    }

    private String generateQuery(String methodName, String[] keys, Object[] values) {
        @SuppressWarnings("unchecked")
        List<Pair<String, String>> params =
                IntStream.range(0, values.length)
                        .filter(i -> values[i] != null)
                        .mapToObj(i -> new Pair<>(keys[i], values[i].toString()))
                        .collect(Collectors.toList());

        if(hasOnlyConfigParams(params)) return null;

        Account account = Account.getInstance();
        String apiKey = account.getApiKey();
        String secret = account.getSecret();

        String query = "http://codeforces.com/api/" + methodName + "?";
        boolean hasSecretUserData = apiKey != null && secret != null;
        query += getQueryParams(methodName, params, hasSecretUserData);

        return query;
    }
    private boolean hasOnlyConfigParams(List<Pair<String, String>> params) {
        for (Pair<String, String> param : params) {
            String key = param.getKey();
            if (    key.equals("lang")   ||
                    key.equals("apiKey") ||
                    key.equals("time")   ||
                    key.equals("apiSig")) continue;

            return false;
        }
        return true;
    }

    private String getQueryParams(String methodName, List<Pair<String, String>> params, boolean includeApiSig) {
        String lang = Account.getInstance().getLanguage();
        if (lang != null) params.add(new Pair<>("lang", lang));
        return includeApiSig ? getQueryParamsWithApiSig(methodName, params) : getQueryParamsStandard(params);
    }
    private String getQueryParamsWithApiSig(String methodName, List<Pair<String, String>> params) {
        Account account = Account.getInstance();
        String apiKey = account.getApiKey();
        String secret = account.getSecret();
        String time = Long.toString(System.currentTimeMillis() / 1000);
        String rand = Integer.toString(RandomUtils.nextInt(1_000_00, 1_000_000));

        params.add(new Pair<>("apiKey", apiKey));
        params.add(new Pair<>("time", time));

        Comparator<Pair<String, String>> kvComparator = Comparator.<Pair<String, String>, String>comparing(Pair::getKey).thenComparing(Pair::getValue);
        String sortedStringParams = params.stream().sorted(kvComparator).map(p -> p.getKey() + "=" + p.getValue()).collect(Collectors.joining("&"));
        String forSHA512 = rand + "/" + methodName + "?" + sortedStringParams + "#" + secret;
        String sha512Hex = DigestUtils.sha512Hex(forSHA512);
        String apiSig = rand + sha512Hex;

        params.add(new Pair<>("apiSig", apiSig));
        return params.stream().map(p -> p.getKey() + "=" + p.getValue()).collect(Collectors.joining("&")) + "#" + sha512Hex;
    }
    private String getQueryParamsStandard(List<Pair<String, String>> params) {
        return params.stream().map(p -> p.getKey() + "=" + p.getValue()).collect(Collectors.joining("&"));
    }

    private String sendQuery(String query) {
        try {
            RunnableFuture<String> sender = new FutureTask<>(() -> {
                URL url = new URL(query);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                String json = br.readLine();
                return json;
            });
            ServiceHolder.getMainApp().submitTask(sender);
            return sender.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            return getFailedCFResponseJson(e);
        }
    }

    private static String getFailedCFResponseJson(Exception e) {
        String message = e.getMessage();
        CFResponse.ExtendedStatus extendedStatus = CFResponse.ExtendedStatus.SERVER_ERROR;
        if (message != null && message.startsWith("java.io.IOException: Server returned HTTP response code: 400"))
            extendedStatus = CFResponse.ExtendedStatus.USER_NOT_FOUND;
        CFResponse response = CFResponse.getFailedCFResponse(message, extendedStatus);
        return new Gson().toJson(response);
    }

    private void trySleep() {
        try {
            if (sleeper != null) sleeper.get();
            sleeper = CompletableFuture.runAsync(() -> sleep(CF_COOLDOWN));
        } catch (InterruptedException | ExecutionException e) {
            Logger.getGlobal().warning("Thread CFHandler has been interrupted");
        }
    }
    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}