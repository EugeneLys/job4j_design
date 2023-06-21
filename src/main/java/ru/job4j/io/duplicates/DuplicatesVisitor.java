package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private HashMap<FileProperty, List<Path>> map = new HashMap<>();
    private HashSet<FileProperty> set = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toFile().isFile()) {
            FileProperty temp = new FileProperty(file.toFile().length(), file.toFile().getName());
            List<Path> list = new ArrayList<>();
            if (map.containsKey(temp)) {
                set.add(temp);
                list = map.get(temp);
                list.add(file.toAbsolutePath());
                map.replace(temp, list);
            } else {
                list.add(file.toAbsolutePath());
                map.put(temp, list);
            }
        }
        return super.visitFile(file, attrs);
    }

    public void print() {
        for (FileProperty fp : set) {
            System.out.println(fp.getName() + ", " + fp.getSize());
            for (Path path : map.get(fp)) {
                System.out.println(path);
            }
        }
    }
}