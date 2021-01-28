package com.boatrain.interview.microsoft;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            nums[i] = nums[i + 1] * nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            output[i] = output[i] * nums[i + 1];
        }
        return output;
    }
}