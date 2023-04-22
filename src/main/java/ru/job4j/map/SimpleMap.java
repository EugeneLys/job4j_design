package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if ((float) count / capacity >= LOAD_FACTOR) {
            expand();
        }
        boolean rsl = false;
        int h = hash(Objects.hashCode(key));
        int index = indexFor(h);
        if (table[index] == null) {
            table[index] = new MapEntry<K, V>(key, value);
            count++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> capacity);
    }

    private int indexFor(int hash) {
        return hash & capacity - 1;
    }

    private void expand() {
        MapEntry<K, V>[] temp = Arrays.copyOf(table, table.length);
        capacity *= 2;
        table = new MapEntry[capacity];
        count = 0;
        for (MapEntry<K, V> t : temp) {
            if (t != null) {
                int h = hash(Objects.hashCode(t.key));
                int index = indexFor(h);
                if (table[index] == null) {
                    table[index] = t;
                    count++;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        if (key == null) {
            if (table[0] != null) {
                result = table[0].key == null ? table[0].value : null;
            }
        } else {
            int index = indexFor(hash(key.hashCode()));
            var entry = table[index];
            if (entry != null && entry.key != null) {
                if (entry.key.hashCode() == key.hashCode()) {
                    result = entry.key.equals(key) ? entry.value : null;
                }
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        if (key == null) {
            if (table[0].key == null) {
                table[0] = null;
                count--;
                rsl = true;
            }
        } else {
            for (int i = 0; i < table.length; i++) {
                if (table[i] != null && table[i].key != null) {
                    if (table[i].key.hashCode() == key.hashCode() && table[i].key.equals(key)) {
                        table[i] = null;
                        modCount++;
                        count--;
                        rsl = true;
                        break;
                    }
                }
            }
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int expectedModCount = modCount;
            private int point;
            private int start;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < count;
            }

            @Override
            public K next() {
                K rsl = null;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                for (int i = start; i < table.length; i++) {
                    if (table[i] != null) {
                        rsl = table[i].key;
                        start = i + 1;
                        point++;
                        break;
                    }
                }
                return rsl;
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
