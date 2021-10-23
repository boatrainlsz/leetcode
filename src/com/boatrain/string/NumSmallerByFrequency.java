package com.boatrain.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class NumSmallerByFrequency {
    public static void main(String[] args) {
        NumSmallerByFrequency solution = new NumSmallerByFrequency();
        String[] queries=new String[]{"cbd"};
        String[] words=new String[]{"zaaaz"};
        System.out.println(Arrays.toString(solution.numSmallerByFrequency(queries, words)));
    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        Integer[] queryCount = new Integer[queries.length];
        Integer[] wordCount = new Integer[words.length];
        for (int i = 0; i < queries.length; i++) {
            queryCount[i] = freq(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            wordCount[i] = freq(words[i]);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (queryCount[i] < wordCount[j]) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    private int freq(String str) {
        Map<Character, Integer> count = new HashMap<>();
        char[] chars = str.toCharArray();
        Character[] arr = new Character[chars.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = chars[i];
            count.merge(arr[i], 1, Integer::sum);
        }
        Arrays.sort(arr, Comparator.comparingInt(c -> c));
        return count.get(arr[0]);
    }

}
