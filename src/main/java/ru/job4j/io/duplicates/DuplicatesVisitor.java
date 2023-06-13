package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.HashSet;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private HashMap<FileProperty, Path> map = new HashMap<>();
    private HashSet<String> set = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toFile().isFile()) {
            FileProperty temp = new FileProperty(file.toFile().length(), file.toFile().getName());
            if (map.containsKey(temp)) {
                if (set.add(temp.getName())) {
                    System.out.println(temp.getName() + ", " + temp.getSize());
                    System.out.println(map.get(temp));
                }
                System.out.println(temp.getName() + ", " + temp.getSize());
                System.out.println(file.toAbsolutePath());
            } else {
                map.put(temp, file.toAbsolutePath());
            }
        }
        return super.visitFile(file, attrs);
    }
}
