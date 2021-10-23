package com.boatrain.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStrChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] count = new int[words.length];
        Arrays.fill(count, 1);
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPredecessor(words[i], words[j])) {
                    count[j] = Math.max(count[i] + 1, count[j]);
                }
            }
        }
        return Arrays.stream(count).max().getAsInt();
    }

    private boolean isPredecessor(String a, String b) {
        if (a.length() != b.length() - 1) return false;
        int i = 0, j = 0, diff = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
