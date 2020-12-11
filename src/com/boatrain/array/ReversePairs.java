package com.boatrain.array;

public class ReversePairs {
    public static void main(String[] args) {
        ReversePairs solution = new ReversePairs();
        int[] nums = new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(solution.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((long) nums[i] >  (2 * (long)nums[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}
