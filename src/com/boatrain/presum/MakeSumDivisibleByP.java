package com.boatrain.presum;

/*
https://leetcode.cn/problems/make-sum-divisible-by-p/
* */
public class MakeSumDivisibleByP {
    public static void main(String[] args) {
        MakeSumDivisibleByP solution = new MakeSumDivisibleByP();
        System.out.println(solution.minSubarray(new int[]{1000000000,1000000000,1000000000}, 3));
    }

    public int minSubarray(int[] nums, int p) {
        long[] presum = new long[nums.length];
        presum[0] = nums[0];
        for (int i = 1; i < presum.length; i++) {
            presum[i] = presum[i - 1] + nums[i];
        }
        long total = presum[presum.length - 1];
        if (total % p == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < presum.length; i++) {
            for (int j = i; j < presum.length; j++) {
                long remain = total - presum[j] + (i == 0 ? 0 : presum[i - 1]);
                if (remain != 0 && remain % p == 0) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}