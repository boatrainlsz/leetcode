package com.boatrain.array;

import java.util.Arrays;

public class MakeArrayZeroBySubtractingEqualAmounts {
    public static void main(String[] args) {
        MakeArrayZeroBySubtractingEqualAmounts solution = new MakeArrayZeroBySubtractingEqualAmounts();
        System.out.println(solution.minimumOperations(new int[]{1, 5, 0, 3, 5}));
    }

    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int temp = nums[i];
            for (int j = i; j < nums.length; j++) {
                nums[j] -= temp;
            }
            ans++;
        }
        return ans;
    }
}