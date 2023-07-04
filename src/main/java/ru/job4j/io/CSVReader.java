package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        Path path = Paths.get(argsName.get("path"));
        Scanner scanner = new Scanner(path);
        String[] filters = argsName.get("filter").split(",");
        String[] words = scanner.nextLine().split(argsName.get("delimiter"));
        List<Integer> indexes = new ArrayList<>();
        for (String filter : filters) {
            for (int index = 0; index < words.length; index++) {
                if (filter.equals(words[index])) {
                    indexes.add(index);
                }
            }
        }
        while (words != null) {
            StringJoiner stringJoiner = new StringJoiner(";");
            for (int index : indexes) {
                stringJoiner.add(words[index]);
            }
            System.out.println(stringJoiner);
            words = scanner.hasNextLine() ? scanner.nextLine().split(";") : null;
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("This program requires 4 arguments to execute");
        }
        File file = new File(args[0].substring(args[0].indexOf("=") + 1));
        if (!file.exists()) {
            throw new IllegalArgumentException("Bad root argument, no such directory was found");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}