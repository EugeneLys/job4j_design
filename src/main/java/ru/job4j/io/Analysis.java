package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
        BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String str = reader.readLine();
            while (str != null) {
                if (str.startsWith("400") || str.startsWith("500")) {
                    writer.write(str + ";", 4, str.length() - 4);
                    writer.write(";");
                    while (str.startsWith("400") || str.startsWith("500")) {
                        str = reader.readLine();
                    }
                    writer.write(str, 4, str.length() - 4);
                    writer.write(";");
                    writer.newLine();
                }
                str = reader.readLine();
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
