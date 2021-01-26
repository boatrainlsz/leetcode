package com.boatrain.interview.microsoft;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 滑动窗口
 */
public class LongestSubstrWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstrWithoutRepeatingCharacters solution = new LongestSubstrWithoutRepeatingCharacters();
        String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int n = s.length();
        char[] chars = s.toCharArray();
        int right = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(chars[i - 1]);
            }
            while (right + 1 < n && !set.contains(chars[right + 1])) {
                set.add(chars[right + 1]);
                right++;
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }
}