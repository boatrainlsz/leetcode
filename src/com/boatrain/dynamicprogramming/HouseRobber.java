package com.boatrain.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(new HouseRobber().rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] trophies = new int[nums.length];
        trophies[0] = nums[0];
        trophies[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            trophies[i] = Math.max(trophies[i - 1], trophies[i - 2] + nums[i]);
        }
        return trophies[trophies.length - 1];
    }
}
