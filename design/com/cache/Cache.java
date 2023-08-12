package com.cache;

import java.util.Iterator;

public interface Cache<K, V> {
    V get(K key);

    V put(K key, V v);

    Iterator<CacheNode<K, V>> iterator();
}
