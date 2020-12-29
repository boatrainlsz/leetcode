package com.boatrain.temp;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(solution.lengthOfLIS(nums));
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