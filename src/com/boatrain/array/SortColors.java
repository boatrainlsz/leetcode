package com.boatrain.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors
 */
public class SortColors {
    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
//        int[] nums = {1,2,2,2,2,2,2,2,2,2,2,2, 1,0,0,0,0,0,0,0, 1, 1,1,1,1,1,};
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,};
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        //循环不变量:arr[l,lt]<1,arr[lt+1,i-1]==1,arr[gt,r]>1
        int lt = l - 1, gt = r + 1, i = l;
        int pivot = 1;
        while (true) {
            if (arr[i] == pivot) {
                i++;
            } else if (arr[i] > pivot) {
                gt--;
                swap(arr, i, gt);
            } else if (arr[i] < pivot) {
                lt++;
                swap(arr, i, lt);
                i++;
            }
            //结束循环
            if (i >= gt) {
                break;
            }
        }
        swap(arr, l, Math.max(lt, 0));
    }

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
}
