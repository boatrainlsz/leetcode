package com.boatrain.array.binarysearch;

/**
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 */
public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
