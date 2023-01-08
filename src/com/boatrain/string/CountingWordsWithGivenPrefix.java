package com.boatrain.string;

/**
 * https://leetcode.cn/problems/counting-words-with-a-given-prefix/
 */
public class CountingWordsWithGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            if (word.indexOf(pref) == 0) {
                ans++;
            }
        }
        return ans;
    }
}