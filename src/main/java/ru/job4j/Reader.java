package ru.job4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");
        FileReader reader = new FileReader(file);
        while (reader.ready()) {
            System.out.println(reader.read());
        }
    }
}
