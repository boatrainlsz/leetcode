package com.boatrain.dynamicprogramming.string;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("abcda"));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        char[] chars = s.toCharArray();
        if (n == 1) return s;
        if (n == 2) {
            return chars[0] == chars[1] ? s : s.substring(1);
        }
        int maxLen = 1;
        String ans = s.substring(0, 1);
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 2) {
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                } else {
                    isPalindrome[i][j] = false;
                }
                if (maxLen < j - i + 1 && isPalindrome[i][j]) {
                    maxLen = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}