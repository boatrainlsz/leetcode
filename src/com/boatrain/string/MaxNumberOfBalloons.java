package com.boatrain.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/maximum-number-of-balloons/
 */
public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        char[] chars = text.toCharArray();
        int ans = Integer.MAX_VALUE;
        Map<Character, Integer> count = new HashMap<>();
        for (char c : chars) {
            count.merge(c, 1, Integer::sum);
        }
        if (!count.containsKey('b') || !count.containsKey('a') || !count.containsKey('n')
                && !count.containsKey('l') || !count.containsKey('o')) {
            return 0;
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            Character key = entry.getKey();
            if (key.equals('b') || key.equals('a') || key.equals('n')) {
                ans = Math.min(ans, entry.getValue());
            }
            if (key.equals('l') || key.equals('o')) {
                ans = Math.min(ans, entry.getValue() / 2);
            }
        }
        return ans;
    }
}
