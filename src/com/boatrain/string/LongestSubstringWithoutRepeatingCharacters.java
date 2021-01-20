package com.boatrain.string;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        //dvdf
        //pwwkew
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
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

    /**
     * 双指针解法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringDualPointer(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int n = s.length();
        char[] chars = s.toCharArray();
        int right = -1, ans = 0;
        for (int left = 0; left < n; left++) {
            if (left != 0) {
                set.remove(chars[left - 1]);
            }
            while (right + 1 < n && !set.contains(chars[right + 1])) {
                set.add(chars[right + 1]);
                right++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}