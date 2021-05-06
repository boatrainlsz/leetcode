package com.boatrain.numbers;

import java.util.Arrays;

public class DeleteAndEarn {
    public static void main(String[] args) {
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        int[] nums = {3, 4, 2};
        System.out.println(deleteAndEarn.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int[] sums = new int[max + 1];
        for (int num : nums) {
            sums[num] += num;
        }
        int pre = 0;
        int cur = sums[1];
        for (int i = 2; i < max + 1; i++) {
            int temp = cur;
            cur = Math.max(cur, pre + sums[i]);
            pre = temp;
        }
        return cur;
    }
}