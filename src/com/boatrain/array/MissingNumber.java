package com.boatrain.array;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        return n * (n + 1) / 2 - sum;
    }
}
