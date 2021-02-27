package com.boatrain.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int res = 0;
        if (n < k) {
            return 0;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            countMap.merge(s.charAt(i), 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() < k) {
                Character c = entry.getKey();
                /*
                 * 如果一个字符 c在 s 中出现的次数少于 k 次，那么 s 中所有的包含 c 的子字符串都不能满足题意。
                 * 所以，应该在 s 的所有不包含 c 的子字符串中继续寻找结果
                 */String[] split = s.split(String.valueOf(c));
                for (String t : split) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        //如果每个字符 在 s 中出现的次数都不小于 k 次，则s就是满足题意的结果
        return n;
    }
}