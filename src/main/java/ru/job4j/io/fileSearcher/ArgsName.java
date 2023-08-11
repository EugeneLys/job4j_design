package ru.job4j.io.fileSearcher;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("This key: '" + key + "' is missing");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        String reg = "=";
        for (String arg : args) {
            check(arg);
            int index = arg.indexOf('=');
            values.put(arg.substring(1, index), arg.substring(index + 1));
        }
    }

    private static void check(String str) {
        String prefix = "Error: This argument '" + str;
        if (!str.contains("=")) {
            throw new IllegalArgumentException(prefix + "' does not contain an equal sign");
        }
        if (!str.startsWith("-")) {
            throw new IllegalArgumentException(prefix + "' does not start with a '-' character");
        }
        if (str.startsWith("-=")) {
            throw new IllegalArgumentException(prefix + "' does not contain a key");
        }
        if (str.indexOf("=") == str.length() - 1) {
            throw new IllegalArgumentException(prefix + "' does not contain a value");
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }

        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
