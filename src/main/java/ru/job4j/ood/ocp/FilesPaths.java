package ru.job4j.ood.ocp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesPaths {

    public void deleteFile1() throws IOException {
        Files.delete(Path.of("Box.java"));
    }

    public void deleteFile2() throws IOException {
        Files.delete(Path.of("Model.java"));
    }

    /*
    Нарушением OPC является создание отдельных методов для удаления каждого файла.
    Правильно будет создать абстракцию - единый для удаления всех файлов
    метод delete(), в который передается параметр - переменная класса Path.
     */

    public void delete(Path path) throws IOException {
        Files.delete(path);
    }
}
