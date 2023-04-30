package ru.job4j.map;
import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & capacity - 1;
    }

    private int findIndex(K key) {
        return key == null ? 0 : indexFor(hash(key.hashCode()));
    }

    private boolean check(K key, int index) {
        return table[index] != null && Objects.hashCode(table[index].key) == Objects.hashCode(key)
                && Objects.equals(table[index].key, key);
    }

    private void expand() {
        MapEntry<K, V>[] temp = Arrays.copyOf(table, table.length);
        capacity *= 2;
        table = new MapEntry[capacity];
        count = 0;
        for (MapEntry<K, V> t : temp) {
            if (t != null) {
                int index = findIndex(t.key);
                table[index] = t;
                count++;
            }
        }
    }

    @Override
    public boolean put(K key, V value) {
        if ((float) count / capacity >= LOAD_FACTOR) {
            expand();
        }
        boolean rsl = false;
        int index = findIndex(key);
        if (table[index] == null) {
            table[index] = new MapEntry<K, V>(key, value);
            count++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        return check(key, index) ? table[index].value : null;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        int index = findIndex(key);
        if (check(key, index)) {
            table[index] = null;
            modCount++;
            count--;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int expectedModCount = modCount;
            private int start;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (start < table.length && table[start] == null) {
                    start++;
                }
                return start < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[start++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}