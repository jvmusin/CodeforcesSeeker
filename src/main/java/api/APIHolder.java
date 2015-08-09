package api;

import api.interfaces.ContestAPI;
import api.interfaces.ProblemsetAPI;
import api.interfaces.UserAPI;

import java.lang.reflect.Proxy;

public final class APIHolder {

    private APIHolder() {}

    private static GeneralAPI generalAPI =
            (GeneralAPI) Proxy.newProxyInstance(
                    GeneralAPI.class.getClassLoader(),
                    new Class<?>[]{GeneralAPI.class},
                    new CFHandler()
            );

    public static ContestAPI getContestAPI() {
        return generalAPI;
    }
    public static ProblemsetAPI getProblemsetAPI() {
        return generalAPI;
    }
    public static UserAPI getUserAPI() {
        return generalAPI;
    }

    private interface GeneralAPI extends ContestAPI, ProblemsetAPI, UserAPI {}
}
