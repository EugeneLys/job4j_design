package ru.job4j.cache;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String source = cachingDir.concat(key);
        String result = null;
        try {
            result = Files.lines(Paths.get(source)).reduce("", (a, b) -> a + "\n" + b);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Try again with correct file path and name");
        }
        return result;
    }

}
