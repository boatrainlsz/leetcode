package com.boatrain.string;

/**
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        String sub = s.substring(0, n);
        return s.substring(n) + sub;
    }
}
