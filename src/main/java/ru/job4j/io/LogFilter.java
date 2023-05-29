package ru.job4j.io;

import java.io.*;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
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

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)))) {
            for (String str : log) {
                out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("data/log.txt");
        save(log, "data/404.txt");
    }
}
