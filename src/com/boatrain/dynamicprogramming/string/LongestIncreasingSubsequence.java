package com.boatrain.dynamicprogramming.string;

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
        int[] dp = new int[nums.length];
        int ans = 1;
        int len = nums.length;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] =1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}