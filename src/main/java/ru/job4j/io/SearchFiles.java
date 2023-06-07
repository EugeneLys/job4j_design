package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles extends SimpleFileVisitor<Path> {

    Predicate<Path> condition;

    public SearchFiles(Predicate<Path> condition) {
        this.condition = condition;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        List<String> lines = Files.readAllLines(file);
        for (String s: lines) {
            if (s.contains("This is the file we need")) {
                System.out.println("Нужный файл обнаружен!");
                System.out.println(file.toAbsolutePath());
                break;
            }
        }
        return FileVisitResult.CONTINUE;
    }
}