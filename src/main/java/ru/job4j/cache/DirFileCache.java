package ru.job4j.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String result = null;
        try {
            result = Files.lines(Paths.get(key)).reduce("", String::concat);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");;
        } catch (IOException e) {
            System.out.println("Wrong file name");;
        }
        /*String name = String.join(cachingDir, key);
        try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
            StringBuilder line = new StringBuilder();
            while (reader.readLine() != null) {
                line.append(reader.readLine());
            }
            result = String.valueOf(line);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");;
        } catch (IOException e) {
            System.out.println("Wrong file name");;
        }*/
        return result;
    }

}
