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
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & capacity - 1;
    }

    private boolean equalityCheck(MapEntry<K, V> entry, K key) {
        boolean rsl;
        if (key == null) {
            entry = table[0];
            rsl = entry != null && entry.key == null;
        } else {
            rsl = entry != null && entry.key != null
                    && entry.key.hashCode() == key.hashCode() && entry.key.equals(key);
        }
        return rsl;
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
                table[index] = t;
                count++;
            }
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (MapEntry<K, V> entry : table) {
            if (equalityCheck(entry, key)) {
                result = entry.value;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean rsl = false;
        for (int i = 0; i < table.length; i++) {
            if (equalityCheck(table[i], key)) {
                table[i] = null;
                modCount++;
                count--;
                rsl = true;
                break;
            }
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
                while (start < table.length - 1 && table[start] == null) {
                    start++;
                }
                return start < table.length && table[start] != null;
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
