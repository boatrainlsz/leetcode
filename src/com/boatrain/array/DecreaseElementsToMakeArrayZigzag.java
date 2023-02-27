package com.boatrain.array;

public class DecreaseElementsToMakeArrayZigzag {
    public static void main(String[] args) {
        DecreaseElementsToMakeArrayZigzag solution = new DecreaseElementsToMakeArrayZigzag();
        System.out.println(solution.movesToMakeZigzag(new int[]{2, 7, 10, 9, 8, 9}));
    }

    public int movesToMakeZigzag(int[] nums) {
        return Math.min(doMove(nums, 0), doMove(nums, 1));
    }

    private int doMove(int[] nums, int start) {
        int res = 0;
        for (int i = start; i < nums.length; i += 2) {
            //i在谷底
            int temp = 0;
            if (i - 1 >= 0) {
                temp = Math.max(temp, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 <= nums.length - 1) {
                temp = Math.max(temp, nums[i] - nums[i + 1] + 1);
            }
            res += temp;
        }
        return res;
    }
}