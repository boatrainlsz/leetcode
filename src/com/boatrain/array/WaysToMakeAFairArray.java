package com.boatrain.array;

public class WaysToMakeAFairArray {
    public static void main(String[] args) {
        WaysToMakeAFairArray solution = new WaysToMakeAFairArray();
        System.out.println(solution.waysToMakeFair(new int[]{1, 1, 1}));
    }

    public int waysToMakeFair(int[] nums) {
        int count = 0;
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }
        int preEvenSum =0;
        int preOddSum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                preOddSum += nums[i - 1];
            } else {
                preEvenSum += nums[i - 1];
            }
            if (evenSum - preEvenSum == oddSum - preOddSum) {
                count++;
            }
        }
        return count;
    }
}
