package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (!check(args)) {
            throw new IllegalArgumentException();
        }
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static boolean check(String[] args) {
        boolean rsl = true;
        File file = new File(args[0]);
        if (args.length != 2) {
            rsl = false;
            System.out.println("Requires 2 arguments");
        } else if (!file.isDirectory()) {
            rsl = false;
            System.out.println("Bad root argument, no such directory");
        } else if (!args[1].equals(".js")) {
            rsl = false;
            System.out.println("Bad file extension argument");
        }
        return rsl;
    }
}
