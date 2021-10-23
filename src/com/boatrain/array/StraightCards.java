package com.boatrain.array;

import java.util.Arrays;

public class StraightCards {
    public boolean isStraight(int[] nums) {
        if (nums.length != 5) return false;
        int kingCount = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == 0) kingCount++;
        }
        if (kingCount == 4) return true;
        if (kingCount == 3) {
            return nums[nums.length - 1] - nums[kingCount] <= 4;
        }
        for (int i = kingCount; i < nums.length - 1; i++) {
            int gap = nums[i + 1] - nums[i];
            if (gap == 0) return false;
            if (gap > 3) {
                return false;
            } else if (gap != 1) {
                kingCount -= gap - 1;
                if (kingCount < 0) return false;
            }
        }
        return true;
    }
}