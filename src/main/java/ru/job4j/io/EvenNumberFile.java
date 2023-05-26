package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] array = text.toString().split("\r\n");
            String rsl;
            for (String s : array) {
                rsl = Integer.parseInt(s) % 2 == 0 ? " is even" : " is odd";
                System.out.println(s + rsl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}