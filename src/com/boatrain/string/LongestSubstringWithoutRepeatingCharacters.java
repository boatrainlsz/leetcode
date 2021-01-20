package com.boatrain.string;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        //dvdf
        //pwwkew
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        int ans = 1;
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(chars[i]);
            for (int j = i + 1; j < n; j++) {
                if (!set.contains(chars[j])) {
                    set.add(chars[j]);
                } else {
                    break;
                }
                ans = Math.max(ans, set.size());
            }
        }
        return ans;
    }
}