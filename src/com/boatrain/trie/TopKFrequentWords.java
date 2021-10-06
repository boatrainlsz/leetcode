package com.boatrain.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}
                , 2));
    }

    HashMap<String, Integer> countMap = new HashMap<>();

    public List<String> topKFrequent(String[] words, int k) {
        for (String word : words) {
            countMap.merge(word, 1, Integer::sum);
        }
        HashSet<String> wordsSet = new HashSet<>(countMap.keySet());
        PriorityQueue<String> maxHeap = new PriorityQueue<>((str1, str2) -> {
            if (countMap.get(str1) > countMap.get(str2)) {
                return -1;
            } else if (countMap.get(str1) < countMap.get(str2)) {
                return 1;
            } else {
                return str1.compareTo(str2);
            }
        });
        for (String word : wordsSet) {
            maxHeap.add(word);
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <k; i++) {
            ans.add(maxHeap.poll());
        }
        return ans;
    }
}
