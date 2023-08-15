package ru.job4j.io.filesearcher;

import java.io.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class SearchProgram {

    private static Map<String, String> values = new HashMap<>();
    private static Predicate<Path> predicate = null;

    public static void main(String[] args) throws IOException {
        parse(args);
        checkParameters(args);
        Path start = Paths.get(values.get("d"));
        getPredicate(values.get("t"));
        try (FileWriter fw = new FileWriter(values.get("o"))) {
            for (Path p : search(start, predicate)) {
                fw.write(p.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parse(String[] args) {
        for (String arg : args) {
            checkArg(arg);
            int index = arg.indexOf('=');
            values.put(arg.substring(1, index), arg.substring(index + 1));
        }
    }

    public static List<Path> search(Path root, Predicate<Path> predicate) throws IOException {
        FileTreeWalker walker = new FileTreeWalker(predicate);
        Files.walkFileTree(root, walker);
        return walker.getFilesList();
    }

    public static void checkArg(String str) {
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

    public static void checkParameters(String[] args) {
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
            Pattern pattern = Pattern.compile(values.get("n"));
            predicate = p -> pattern.matcher(p.toString()).find();
        } else if ("mask".equals(arg)) {
            Pattern pattern = Pattern.compile(transferToRegex(values.get("n")));
            predicate = p -> pattern.matcher(p.toString()).find();
        } else {
            throw new IllegalArgumentException("Bad search type parameter");
        }
    }

    public static String transferToRegex(String mask) {
        int i = 0;
        StringBuilder regex = new StringBuilder();
        while (i < mask.length()) {
            String str = mask.substring(i, i + 1);
            switch (str) {
                case "*" -> regex.append(".+");
                case "?" -> regex.append("[.]{1}");
                case "." -> regex.append("[\\\\.]");
                default -> regex.append("[").append(str).append("]").append("{1}");
            }
            i++;
        }
        return regex.toString();
    }
}
