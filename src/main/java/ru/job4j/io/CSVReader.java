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
        try (Scanner scan = new Scanner(path); PrintWriter pw = new PrintWriter(new FileWriter(argsName.get("out")))) {
            String[] filters = argsName.get("filter").split(",");
            String[] words = scan.nextLine().split(argsName.get("delimiter"));
            List<Integer> indexes = new ArrayList<>();
            boolean check = "stdout".equals(argsName.get("out"));
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
                stringJoiner.add(System.lineSeparator());
                if (check) {
                    System.out.print(stringJoiner);
                } else {
                    pw.write(stringJoiner.toString());
                }
                words = scan.hasNextLine() ? scan.nextLine().split(";") : null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("This program requires 4 arguments to execute");
        }
        File file = new File(args[0].substring(args[0].indexOf("=") + 1));
        if (!file.exists()) {
            throw new IllegalArgumentException("No such csv file.");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}