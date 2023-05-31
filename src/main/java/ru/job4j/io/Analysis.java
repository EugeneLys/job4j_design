package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Analysis {
    public void unavailable(String source, String target) {
        StringJoiner out = new StringJoiner("");
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
        BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            List<String> list = reader.lines().toList();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).startsWith("400") || list.get(i).startsWith("500")) {
                   out.add(list.get(i).substring(4) + ";");
                   while (list.get(i).startsWith("400") || list.get(i).startsWith("500")) {
                       i++;
                   }
                   out.add(list.get(i).substring(4) + System.lineSeparator());
                }
            }
            writer.write(out.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
