package com.boatrain.array;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(nums, 2));
    }

    private static int partition(int[] arr, int l, int r, int k, Random random) {
        int p = random.nextInt(r - l + 1) + l;
        //交换一下，再开始分区
        swap(arr, l, p);
        int i = l + 1, j = r;
        //arr[l+1,i-1] <=arr[l]，arr[j+1,r] >=arr[l]
        while (true) {
            //找到一个大于等于arr[l]的数arr[i]
            while (i <= j && arr[i] < arr[l]) {
                i++;
            }
            //找到一个小于等于arr[l]的数arr[j]
            while (i <= j && arr[j] > arr[l]) {
                j--;
            }
            if (i >= j) break;
            //交换arr[i],arr[j]
            swap(arr, i, j);
            //继续下一轮寻找，直到i >= j退出循环
            i++;
            j--;
        }
        swap(arr, l, j);
        if (j == k) {
            return arr[k];
        } else if (j < k) {
            return partition(arr, j + 1, r, k, random);
        } else {
            return partition(arr, l, j - 1, k, random);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        int n = nums.length;
        return partition(nums, 0, nums.length - 1, n - k, random);
    }

}
