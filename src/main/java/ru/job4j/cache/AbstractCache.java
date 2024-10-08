package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        cache.put(key, new SoftReference<V>(value));
    }

    public final V get(K key) {
        V result;
        if (cache.get(key) == null || cache.get(key).get() == null) {
            result = load(key);
            put(key, result);
        } else {
            result = cache.get(key).get();
        }
        return result;
    }

    protected abstract V load(K key);
}