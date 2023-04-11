package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int sizeIn;
    private int sizeOut;
    /* добавьте переменные, если они требуются */

    public T poll() {
        return null;
    }

    public void push(T value) {
    }
}
