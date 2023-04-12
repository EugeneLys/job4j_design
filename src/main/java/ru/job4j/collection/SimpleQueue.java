package ru.job4j.collection;

import java.util.NoSuchElementException;
import java.util.Stack;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    private int size;
    private int start;
    /* добавьте переменные, если они требуются */

    public T poll() {
        if (start == size) {
            throw new NoSuchElementException("Queue is empty");
        }
        SimpleStack<T> change;
        change = in;
        for (int i = start; i < size; i++) {
            out.push(change.pop());
        }
        T rsl = out.pop();
        start++;
        return rsl;

    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}
