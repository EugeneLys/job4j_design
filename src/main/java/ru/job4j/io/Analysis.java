package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
        BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            StringBuilder builder = new StringBuilder();
            String str;
            while (reader.ready()) {
                str = reader.readLine();
                if (str.startsWith("400") || str.startsWith("500")) {
                    builder.append(str, 4, str.length());
                    builder.append(";");
                    while (str.startsWith("400") || str.startsWith("500")) {
                        if (reader.ready()) {
                            str = reader.readLine();
                        } else {
                            break;
                        }
                    }
                    if (str.startsWith("200") || str.startsWith("300")) {
                        builder.append(str, 4, str.length());
                        builder.append(";");
                        builder.append("\n");
                    }
                }
            }
            writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
