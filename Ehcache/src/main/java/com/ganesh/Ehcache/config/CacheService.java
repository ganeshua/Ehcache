package com.ganesh.Ehcache.config;

public interface CacheService<K, V> {
    void put(K key, V value);

    V get(K key);
}
