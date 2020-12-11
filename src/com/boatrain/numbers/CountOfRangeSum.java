package com.boatrain.numbers;

/**
 * https://leetcode-cn.com/problems/count-of-range-sum/
 */
public class CountOfRangeSum {
    public static void main(String[] args) {
        CountOfRangeSum solution = new CountOfRangeSum();
        System.out.println(solution.countRangeSum(new int[]{-1, 0, -2147483647, 2147483647}, -564, 3864));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        System.out.println(Integer.MAX_VALUE);
        int count = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            if (sum >= lower && sum <= upper) {
                System.out.println(sum);
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    count++;
                }

            }
        }
        return count;
    }
}
