package com.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LRUCacheImpl<K, V> implements Cache<K, V> {
    private Map<K, LRUCacheCacheNode<K, V>> nodeMap;
    private LRUCacheCacheNode<K, V> head;
    private LRUCacheCacheNode<K, V> tail;
    private int size = 1 << 4;

    public LRUCacheImpl() {
        this.head = new LRUCacheCacheNode<>(null, null);
        this.tail = new LRUCacheCacheNode<>(null, null);
        head.next = tail;
        tail.prev = head;
        nodeMap = new HashMap<>(size);
    }

    public LRUCacheImpl(int size) {
        this.size = size;
        this.head = new LRUCacheCacheNode<>(null, null);
        this.tail = new LRUCacheCacheNode<>(null, null);
        head.next = tail;
        tail.prev = head;
        nodeMap = new HashMap<>(size);
    }

    private void addKey(LRUCacheCacheNode<K, V> LRUCacheNode) {
        LRUCacheCacheNode<K, V> prev = tail.prev;
        prev.next = LRUCacheNode;
        LRUCacheNode.prev = prev;
        LRUCacheNode.next = tail;
        tail.prev = LRUCacheNode;
    }

    private void deleteNode(LRUCacheCacheNode<K, V> LRUCacheNode) {
        LRUCacheCacheNode<K, V> prev = LRUCacheNode.prev;
        LRUCacheCacheNode<K, V> next = LRUCacheNode.next;
        prev.next = next;
        next.prev = prev;
    }

    static class LRUCacheCacheNode<K, V> extends CacheNode<K, V> {
        private LRUCacheCacheNode prev;
        private LRUCacheCacheNode next;

        public LRUCacheCacheNode(K key, V value) {
            super(key, value);
        }

        public String toString() {
            return "[" + key + "," + value + "]";
        }
    }

    @Override
    public V get(K key) {
        if (nodeMap.containsKey(key)) {
            LRUCacheCacheNode<K, V> kvLRUCacheNode = nodeMap.get(key);
            deleteNode(kvLRUCacheNode);
            addKey(kvLRUCacheNode);
            return kvLRUCacheNode.value;
        }
        return null;
    }

    @Override
    public V put(K key, V v) {
        LRUCacheCacheNode<K, V> LRUCacheNode = new LRUCacheCacheNode<>(key, v);
        if (nodeMap.containsKey(key)) {
            deleteNode(nodeMap.get(key));
        }
        addKey(LRUCacheNode);
        nodeMap.put(key, LRUCacheNode);
        if (nodeMap.size() > size) {
            LRUCacheCacheNode next = head.next;
            deleteNode(next);
            nodeMap.remove(next.key);
        }
        return v;
    }

    private class LRUItr implements Iterator<CacheNode<K, V>> {
        LRUCacheCacheNode<K, V> pointer;

        LRUItr() {
            pointer = tail;
        }

        @Override
        public boolean hasNext() {
            return pointer.prev != head;
        }

        @Override
        public CacheNode<K, V> next() {
            pointer = pointer.prev;
            return pointer;
        }
    }


    @Override
    public Iterator<CacheNode<K, V>> iterator() {
        return new LRUItr();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        LRUCacheCacheNode<K, V> LRUCacheNode = head.next;
        while (LRUCacheNode != tail) {
            stringBuilder.append(LRUCacheNode).append(",");
            LRUCacheNode = LRUCacheNode.next;
        }
        return stringBuilder.toString();
    }
}
