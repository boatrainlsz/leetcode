package com.boatrain.string;

import java.util.Arrays;
import java.util.HashSet;

public class MaxProduct {
    public static void main(String[] args) {
        MaxProduct solution = new MaxProduct();
        String[] words=new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(solution.maxProduct(words));
    }
    public int maxProduct(String[] words) {
        int ans = 0;
        HashSet<Character>[] arr = new HashSet[words.length];
        for (int i = 0; i < words.length; i++) {
            arr[i]=new HashSet<>();
            String word = words[i];
            char[] chars = word.toCharArray();
            for (char c : chars) {
                arr[i].add(c);
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (noCommonChar(arr[i], arr[j])) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    private boolean noCommonChar(HashSet<Character> set1, HashSet<Character> set2) {
        for (Character c : set1) {
            if (set2.contains(c)) return false;
        }
        return true;
    }
}