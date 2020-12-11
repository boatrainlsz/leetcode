package com.boatrain.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(new HouseRobberII().rob(nums));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        //抢最后一个
        int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length );
        //抢第一个
        int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        return Math.max(doRob(nums1), doRob(nums2));
    }

    public int doRob(int[] nums) {
        int[] trophies = new int[nums.length];
        trophies[0] = nums[0];
        trophies[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            trophies[i] = Math.max(trophies[i - 1], trophies[i - 2] + nums[i]);
        }
        return trophies[trophies.length - 1];
    }
}
