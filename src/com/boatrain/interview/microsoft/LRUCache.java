package com.boatrain.interview.microsoft;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    private HashMap<Integer, Integer> map = new HashMap<>();
    private Deque<Integer> deque = new LinkedList<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

//    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(10);
//        lRUCache.put(10, 13); // 缓存是 {1=1}
//        lRUCache.put(3, 17); // 缓存是 {1=1, 2=2}
//        lRUCache.put(6, 11);
//        lRUCache.put(10, 5);
//        lRUCache.put(9, 10);
//        lRUCache.get(13);    // 返回 1
//        lRUCache.put(2, 19);
//        lRUCache.get(2);
//        lRUCache.get(3);
//        lRUCache.put(5, 25);
//        lRUCache.get(8);
//        lRUCache.put(9, 22);
//        lRUCache.put(5, 5);
//        lRUCache.put(1, 30);
//        lRUCache.get(11);
//        lRUCache.put(9, 12);
//        lRUCache.get(7);
//        lRUCache.get(5);
//        lRUCache.get(8);
//        lRUCache.get(9);
//        lRUCache.put(4, 30);
//        lRUCache.put(9, 3);
//        lRUCache.get(10);
//        lRUCache.get(10);
//    }

    public int get(int key) {
        if (map.containsKey(key)) {
            deque.remove(key);
            deque.addFirst(key);
        }
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deque.remove(key);
        }else if(deque.size() == capacity){
            Integer last = deque.removeLast();
            map.remove(last);
        }
        deque.addFirst(key);
        map.put(key, value);
    }
}