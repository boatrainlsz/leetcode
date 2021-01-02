package com.boatrain.temp;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            maxHeap.add(new int[]{nums[i], i});
        }
        ans[0] = maxHeap.peek()[0];
        for (int i = k; i < n; i++) {
            maxHeap.add(new int[]{nums[i], i});
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }
            ans[i - k + 1] = maxHeap.peek()[0];
        }
        return ans;
    }
}