package com.cache;

import java.util.Iterator;

public class CacheDemo {
    public static void main(String[] args) {
        Cache<Integer,Integer> cache=new LRUCacheImpl<>();
        cache.put(1,1);
        cache.put(2,4);
        cache.put(3,9);
        System.out.println(cache.get(1));
        cache.put(4,16);
        System.out.println(cache.get(2));
        cache.put(5,25);
        //System.out.println(cache);
        Iterator<CacheNode<Integer, Integer>> iterator = cache.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+",");
        }
        System.out.println();

        Cache<String,String> cache1=new LRUCacheImpl<>(4);
        cache1.put("ab","ba");
        cache1.put("ac","ca");
        cache1.put("fd","fd");
        System.out.println(cache1.get("ab"));
        cache1.put("gfd","dfg");
        System.out.println(cache1.get("ac"));
        cache1.put("asdf","fdsa");
       // System.out.println(cache1);
        Iterator<CacheNode<String, String>> iterator1 = cache1.iterator();
        while (iterator1.hasNext()){
            System.out.print(iterator1.next()+",");
        }
        System.out.println();
    }
}
