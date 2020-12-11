package com.boatrain.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class HouseRobberWithLowMemory {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(new HouseRobberWithLowMemory().rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] trophies = new int[3];
        trophies[0] = nums[0];
        trophies[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) return trophies[1];
        for (int i = 2; i < nums.length; i++) {
            trophies[2] = Math.max(trophies[1], trophies[0] + nums[i]);
            trophies[0] = trophies[1];
            trophies[1]  = trophies[2];
        }
        return trophies[2];
    }
}
