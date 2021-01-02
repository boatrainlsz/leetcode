package com.boatrain.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] nums = new int[]{1, 3, -1, -3, 2, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //pair[0]=num,pair[1]=index，大顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (pair1, pair2) -> pair2[0] - pair1[0]);
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = queue.peek()[0];
        for (int i = k; i < n; i++) {
            queue.add(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }
}
