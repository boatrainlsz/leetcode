package com.boatrain.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence sulotion = new LongestIncreasingSubsequence();
//        int[] nums = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
//        int[] nums = new int[]{1, 2, 3};
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(sulotion.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) return length;
        int[] memo = new int[length];
        memo[0] = 1;
        for (int i = 1; i < length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, memo[j]);
                }
            }
            memo[i] = max + 1;
        }
        int result = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] > result) result = memo[i];
        }
        System.out.println(Arrays.toString(memo));
        return result;
    }
}
