package com.boatrain.array;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        KthLargestElementInAnArray solution = new KthLargestElementInAnArray();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        //有三种方法：
        //快排非递归
        System.out.println(solution.findKthLargestNonR(nums, 2));
        //快排递归
        System.out.println(solution.findKthLargest(nums, 2));
        //小顶堆
        System.out.println(solution.findKthLargestByMinHeap(nums, 2));
    }

    /**
     * @param arr    数组
     * @param l      左端点
     * @param r      右端点
     * @param k      要查找的下标
     * @param random 随机
     * @return arr[l, r]中第k小的元素，k从0开始计数
     */
    private static int selectK(int[] arr, int l, int r, int k, Random random) {
        int j = partition(arr, l, r, random);
        if (j == k) {
            return arr[k];
        } else if (j < k) {
            return selectK(arr, j + 1, r, k, random);
        } else {
            return selectK(arr, l, j - 1, k, random);
        }
    }

    /**
     * 快排里的partition函数
     *
     * @param arr
     * @param l
     * @param r
     * @param random
     * @return
     */
    private static int partition(int[] arr, int l, int r, Random random) {
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
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 递归实现
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        int n = nums.length;
        return selectK(nums, 0, nums.length - 1, n - k, random);
    }

    /**
     * 非递归实现
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestNonR(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = nums.length - 1, target = n - k;
        Random random = new Random();
        while (l <= r) {
            int j = partition(nums, l, r, random);
            if (j == target) {
                return nums[j];
            } else if (j < target) {
                l = j + 1;
            } else {
                r = j - 1;
            }
        }
        return -1;
    }

    /**
     * 用小顶堆
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestByMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                if (queue.peek() < num) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        return queue.poll();
    }
}
