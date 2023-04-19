package ru.job4j.map;

import java.util.Iterator;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count > capacity * 3 / 4) {
            expand();
        }
        boolean rsl = false;
        int h = hash(Objects.hashCode(key));
        int index = indexFor(h);
        if (table[index] == null) {
            table[index] = new MapEntry<K, V>(key, value);
            count++;
            return rsl;
        }
        table[count] = new MapEntry<K, V>(key, value);
        count++;
        return false;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode>>>8);
    }

    private int indexFor(int hash) {
        return hash & capacity - 1;
    }

    private void expand() {
        MapEntry<K, V>[] next = new MapEntry[capacity * 2];
        for (MapEntry<K, V> me : table) {
            next.put(me.key, me.value);
        }
        table = map;
    }

    @Override
    public V get(K key) {
        V result = null;
        for (MapEntry<K, V> me : table) {
            if (me.key.equals(key)) {
                result = me.value;
                break;
            }
        }
        return result;

    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
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
