package com.boatrain.interview.microsoft;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */

import java.util.Arrays;
import java.util.Random;

public class SortColors {
    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int[] nums = {2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        Random random = new Random();
        quickSort(nums, 0, nums.length - 1, random);
    }

    private void quickSort(int[] nums, int l, int r, Random random) {
        if (l >= r) return;
        int p = l + random.nextInt(r - l + 1);
        swap(nums, l, p);
        // [l+1,lt]<nums[l],[lt+1,i-1]=nums[l],[i,gt-1]：待考察区域 [gt,r]>nums[l]
        //初始化
        int lt = l, gt = r + 1, i = l + 1;
        int pivot = nums[l];
        while (true) {
            if (nums[i] == pivot) {
                i++;
            } else if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
                i++;
            } else if (nums[i] > pivot) {
                gt--;
                swap(nums, gt, i);
            }
            if (i >= gt) {
                break;
            }
        }
        //before swap:[l+1,lt]<nums[l],[lt+1,gt-1]=nums[l], [gt,r]>nums[l]
        swap(nums, l, lt);
        //after swap:[l,lt-1]<nums[l],[lt,gt-1]=nums[l], [gt,r]>nums[l]
        quickSort(nums, l, lt - 1, random);
        quickSort(nums, gt, r, random);
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
