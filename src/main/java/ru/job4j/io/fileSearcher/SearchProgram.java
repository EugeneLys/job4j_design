package ru.job4j.io.fileSearcher;

import ru.job4j.io.ArgsName;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class SearchProgram {

    private static final Map<String, String> values = new HashMap<>();
    private static Predicate<Path> predicate = null;

    public static void main(String[] args) throws IOException {
        parse(args);
        checkParameters(args);
        Path start = Paths.get(values.get("d"));
        getPredicate(values.get("t"));
        search(start, predicate).forEach(System.out::println);
    }

    private static void parse(String[] args) {
        String reg = "=";
        for (String arg : args) {
            checkArg(arg);
            int index = arg.indexOf('=');
            values.put(arg.substring(1, index), arg.substring(index + 1));
        }
    }

    private static void checkArg(String str) {
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

    public static List<Path> search(Path root, Predicate<Path> predicate) throws IOException {
        FileTreeWalker walker = new FileTreeWalker(predicate);
        Files.walkFileTree(root, walker);
        return walker.getFilesList();
    }

    private static void checkParameters(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("4 args required");
        }
        File file = new File(values.get("d"));
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Bad root argument, no such directory was found");
        }
    }

    public static void getPredicate(String arg) {
        if ("name".equals(arg)) {
            predicate = p -> p.toFile().getName().equals(values.get("n"));
        } else if ("regex".equals(arg)) {
            Pattern pattern = Pattern.compile(arg);
            predicate = p -> pattern.matcher(p.toString()).find();
        } else if ("mask".equals(arg)) {

        } else {
            throw new IllegalArgumentException("Bad predicate");
        }
    }
}
