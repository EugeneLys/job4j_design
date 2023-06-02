package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
        BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String str;
            while (reader.ready()) {
                str = reader.readLine();
                if (str.startsWith("400") || str.startsWith("500")) {
                    writer.append(str, 4, str.length()).append(";");
                    while (str.startsWith("400") || str.startsWith("500") && reader.ready()) {
                        str = reader.readLine();
                    }
                    if (str.startsWith("200") || str.startsWith("300")) {
                        writer.append(str, 4, str.length()).append(";").append(System.lineSeparator());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
