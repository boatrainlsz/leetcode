package com.boatrain.interview.microsoft;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private HashMap<Integer, Node> map = new HashMap<>();
    private int capacity;
    private int size;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(Integer.MIN_VALUE, Integer.MAX_VALUE);
        tail = new Node(Integer.MIN_VALUE, Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        move2Head(node);
        return node.value;
    }

    private void move2Head(Node node) {
        removeNode(node);
        add2Head(node);
    }

    private void add2Head(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            add2Head(node);
            map.put(key, node);
            size++;
        } else {
            node.value = value;
            move2Head(node);
        }
        if (size > capacity) {
            removeTail();
            size--;
        }
    }

    private void removeTail() {
        map.remove(tail.prev.key);
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;

    }

    private static class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */