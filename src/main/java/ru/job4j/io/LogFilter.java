package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> rsl = null;
        String check = "\" 404";
        try (BufferedReader in = new BufferedReader(new FileReader("data/log.txt"))) {
            rsl = in.lines()
                    .filter(l -> l.regionMatches(l.lastIndexOf("\""), check, 0, check.length()))
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("data/log.txt");
        log.forEach(System.out::println);
    }
}
