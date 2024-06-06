package ru.job4j;

import java.io.*;

public class Reader {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\cache\\text.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            System.out.println(reader.readLine());
        }
    }
}
