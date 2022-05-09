package com.boatrain;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/stock-price-fluctuation/
 */
public class StockPrice {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        stockPrice.current();
        stockPrice.maximum();
        stockPrice.update(1, 3);
        stockPrice.maximum();
        stockPrice.update(4, 2);
        stockPrice.minimum();
    }

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    Map<Integer, Integer> map;

    private int current;

    public StockPrice() {
        minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> map.get(o)));
        maxHeap = new PriorityQueue<>((o1, o2) -> {

            return map.get(o2) - map.get(o1);
        });
        map = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        current = Math.max(timestamp, current);
        if (!Integer.valueOf(price).equals(map.get(timestamp))) {
            map.put(timestamp, price);
            minHeap.add(timestamp);
            maxHeap.add(timestamp);
        }
    }

    public int current() {
        return map.get(current);
    }

    public int maximum() {
        return map.get(maxHeap.peek());
    }

    public int minimum() {
        return map.get(minHeap.peek());
    }
}
