package com.ganesh.Ehcache.config;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class CacheServiceImpl<K, V> implements CacheService<K, V> {

    private final String cacheName;
    private final CacheManager cacheManager;

    public CacheServiceImpl(String cacheName, CacheManager cacheManager) {
        this.cacheName = cacheName;
        this.cacheManager = cacheManager;
    }

    @Override
    public void put(K key, V value) {
        getCache().put(new Element(key, value));

    }

    @Override
    public V get(K key) {
        Element element = getCache().get(key);
        if (element != null)
            return (V) element.getObjectValue();

        return null;
    }

    private Ehcache getCache() {
        //cache name from ehcache.xml
        return cacheManager.getEhcache(cacheName);
    }
}
