package com.boatrain.stackandqueue;

/**
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses
 */
public class MaxDepth {
    public int maxDepth(String s) {
        int ans = 0, size = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                size++;
                ans = Math.max(ans, size);
            } else if (c == ')') {
                size--;
            }
        }
        return ans;
    }
}
