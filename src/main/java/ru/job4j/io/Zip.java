package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
               zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("Not enough arguments.");
        }
        ArgsName argsName = ArgsName.of(args);
        if (!Path.of(argsName.get("d")).toFile().isDirectory()) {
            throw new IllegalArgumentException("Can't find directory to archive");
        }
        List<Path> source = Search.search(Path.of(argsName.get("d")), p -> !p.toFile().getName().endsWith(argsName.get("e")));
        Zip zip = new Zip();
        zip.packFiles(source, new File(argsName.get("o")));
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}
