package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        StringJoiner stringJoiner = new StringJoiner(",");
        Scanner scanner = new Scanner(argsName.get("path"));
        String[] filters = argsName.get("filter").split(";");
        String[] words = scanner.nextLine().split(",");
        List<Integer> indexes = new ArrayList<>();
        for (String filter : filters) {
            for (int j = 0; j < words.length; j++) {
                if (filter.equals(words[j])) {
                    indexes.add(j);
                }
            }
        }
        String[] result;
        System.out.println();
        while (scanner.hasNextLine()) {
            words = scanner.nextLine().split(";");
            for (int i : indexes) {
                stringJoiner.add(words[i]);
            }
            System.out.println(stringJoiner);
        }
    }

    public static void main(String[] args) throws Exception {
        /* здесь добавьте валидацию принятых параметров*/
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}