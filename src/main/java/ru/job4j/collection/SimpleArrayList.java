package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            grow();
        }
        container[size] = value;
        size++;
    }

    @Override
    public T set(int index, T newValue) {
        T result = get(index);
        if (size == container.length - 1) {
            grow();
        }
        System.arraycopy(container, index,
                container, index + 1,
                size - index);
        container[index] = newValue;
        size = size + 1;
        return result;
    }

    @Override
    public T remove(int index) {
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[container.length - 1] = null;
        return container[index];
    }

    @Override
    public T get(int index) {
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                while (size < container.length && container[size] != null) {
                    size++;
                }
                return size < container.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[size++];
            }
        };
    }

    private T[] grow() {
        return container = Arrays.copyOf(container, container.length * 2);
    }
}
