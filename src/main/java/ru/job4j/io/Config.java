package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        String div = "=";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            List<String> list = reader.lines().toList();
            for (String str : list) {
                if (!str.startsWith("#") && !str.isEmpty()) {
                    if (str.startsWith(div) || str.endsWith(div) || !str.contains(div)) {
                        throw new IllegalArgumentException();
                    }
                    values.put(str.substring(0, str.indexOf(div)), str.substring(str.indexOf(div) + 1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
    }
}
