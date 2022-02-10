package com.boatrain.presum;

import java.util.HashMap;

public class SubarraySum {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        int k = 3;
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new SubarraySum().subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        if (nums[0] == k) ans++;
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        for (int i = 1; i < preSum.length; i++) {
            if (preSum[i] == k) ans++;
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) ans++;
            }
        }
        return ans;
    }

    class Solution {
        public int subarraySum(int[] nums, int k) {
            int preSum = 0;
            int ret = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int num : nums) {
                preSum += num;
                ret += map.getOrDefault(preSum - k, 0);
                map.merge(preSum, 1, Integer::sum);
            }
            return ret;
        }
    }
}
