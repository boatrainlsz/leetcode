package com.boatrain.numbers;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        return (n + 1) * n / 2 - Arrays.stream(nums).sum();
    }
}
