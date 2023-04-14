package ru.job4j.collection;

import java.util.NoSuchElementException;
import java.util.Stack;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int sizeIn;
    private int sizeOut;

    public T poll() {
        if (sizeIn == 0 && sizeOut == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        if (sizeOut == 0) {
            for (int i = 0; i < sizeIn; i++) {
                out.push(in.pop());
                sizeOut++;
            }
            sizeIn = 0;
        }
        T rsl = out.pop();
        sizeOut--;
        return rsl;
    }

    public void push(T value) {
        in.push(value);
        sizeIn++;
    }
}
