package com.boatrain.dualpointer;

/**
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 1;
        int ans = 0;
        while (right <= nums.length) {
            int product = nums[left];
            while (true) {
                if (right == nums.length + 1) {
                    break;
                }
                product *= right - 1 == left ? 1 : nums[right - 1];
                if (product < k) {
                    ans++;
                    right++;
                } else {
                    break;
                }
            }
            left++;
            right = left + 1;
        }
        return ans;
    }
}
