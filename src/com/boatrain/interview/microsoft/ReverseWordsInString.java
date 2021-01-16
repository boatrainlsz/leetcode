package com.boatrain.interview.microsoft;

import java.util.Arrays;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString solution = new ReverseWordsInString();
        System.out.println(solution.reverseWords("  hello world!  "));
    }

    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] split = s.split(" ");
        System.out.println(Arrays.toString(split));
        int n = split.length;
        for (int i = n - 1; i >= 0; i--) {
            String word = split[i];
            if (!Objects.equals(word, "")) {
                ans.append(word).append(" ");
            }
        }
        return ans.substring(0, ans.length() - 1);
    }
}
