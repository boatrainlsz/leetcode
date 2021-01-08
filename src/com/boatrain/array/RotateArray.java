package com.boatrain.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
//        int[] nums = new int[]{1, 2};
        RotateArray solution = new RotateArray();
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (nums.length == 0 || k == 0) return;
        //解法1：每次向右移动一个，循环k次
       /* for (int i = 0; i < k; i++) {
            //最后一个元素暂存
            int temp = nums[n - 1];
            //剩下的元素向后移动一位即可
            for (int j = n - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            //第一个元素赋值为暂存的最后一个元素
            nums[0] = temp;
        }*/

        //解法2：直接一步到位，算出nums[i]向右移动K次落在哪里
        int[] targetArr = new int[n];
        for (int i = 0; i < n; i++) {
            //nums[i]的位置最后变成了(i + k) % n
            targetArr[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = targetArr[i];
        }
    }

}
