package com.boatrain.dynamicprogramming.string;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        char[] chars = s.toCharArray();
        if (n == 1) return s;
        if (n == 2) {
            return chars[0] == chars[1] ? s : s.substring(1);
        }
        int maxLen = 0;
        String ans = "";
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j] && j == i + 1) {
                    isPalindrome[i][j] = true;
                } else if (chars[i] == chars[j] && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(isPalindrome));
        return ans;
    }
}