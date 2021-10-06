package com.boatrain.trie;

public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        char[] words = word.toCharArray();
        Node cur = root;
        for (char c : words) {
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Node(c);
            }
            cur = cur.next[c - 'a'];
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    public boolean search(String word) {
        char[] words = word.toCharArray();
        Node cur = root;
        for (char c : words) {
            if (cur.next[c - 'a'] == null) {
                return false;
            }
            cur = cur.next[c - 'a'];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        char[] prefixes = prefix.toCharArray();
        Node cur = root;
        for (char c : prefixes) {
            if (cur.next[c - 'a'] == null) {
                return false;
            }
            cur = cur.next[c - 'a'];
        }
        return true;
    }

    private static class Node {
        private char c;
        private Node[] next = new Node[26];
        private boolean isWord;

        public Node(char c) {
            this.c = c;
        }

        public Node() {
        }
    }
}