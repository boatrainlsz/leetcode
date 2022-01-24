package com.boatrain.stackandqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 */
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int cnt = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (cnt == k) break;
                List<Integer> pair = new ArrayList<>();
                pair.add(num1);
                pair.add(num2);
                ans.add(pair);
                cnt++;
            }
        }
        return ans;
    }
}
