package core;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelperMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        Pattern p = Pattern.compile("((?<methodName>\\w+)\\((?<before>\\w+), (?<now>\\w+)\\))");
//        while (true) {
//            String line = in.nextLine();
//            Matcher matcher = p.matcher(line);
//            if (matcher.find()) {
//                String methodName = matcher.group("methodName");
//                String before = matcher.group("before");
//                String now = matcher.group("now");
//
//                methodName = "updateDefaultLabels";
//
//                System.out.println(before + ".setText(" + now + ".getText()); " + methodName + "(" + before + ", " + now + ");");
//            } else {
//                System.out.println(line);
//            }
//        }

        while (true)
            System.out.println(in.nextLine().replace("gridController.", ""));
    }
}
