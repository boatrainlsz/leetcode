package com.boatrain.array;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/
 */
public class CountKDifference {
    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
            ans += count.getOrDefault(num + k, 0) + count.getOrDefault(num - k, 0);
        }
        return ans;
    }
}
