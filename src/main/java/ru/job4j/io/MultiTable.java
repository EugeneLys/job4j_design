package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class MultiTable {
    public static int[][] multiple(int size) {
        int[][] array = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                array[row][cell] = (row + 1) * (cell + 1);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[][] table = multiple(99);
        try (FileOutputStream out = new FileOutputStream("data/multitable.txt")) {
            for (int[] row : table) {
                for (int i : row) {
                    out.write(String.valueOf(i).getBytes());
                    out.write(" ".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}