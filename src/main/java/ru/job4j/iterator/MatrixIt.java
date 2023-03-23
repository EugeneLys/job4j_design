package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (data[row].length == 0 && row < data.length - 1) {
            row++;
        }
        if (column == data[row].length && row < data.length - 1) {
            column = 0;
            row++;
            return hasNext();
        }
        return column < data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column == data[row].length) {
            column = 0;
            row++;
            return next();
        }
        return data[row][column++];
        }
    }

