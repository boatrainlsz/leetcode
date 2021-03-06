package com.boatrain.array;

import java.util.Arrays;

public class NextGreaterElementIi {
    public static void main(String[] args) {
        NextGreaterElementIi nextGreaterElementIi = new NextGreaterElementIi();
        System.out.println(Arrays.toString(nextGreaterElementIi.nextGreaterElements(new int[]{1, 2, 1})));
    }

    /**
     * 暴力解法，能AC
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int index = (i + 1) % n;
            ans[i] = -1;
            while (index != i) {
                if (nums[index] > nums[i]) {
                    ans[i] = nums[index];
                    break;
                }
                index = (index + 1) % n;
            }
        }
        return ans;
    }

    /**
     * 更好的解法，单调栈+循环数组
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElementsBetterSolution(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        return ans;
    }
}