package com.boatrain.array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
//        int[] nums = new int[]{1, 3, -1, -3, 2, 3, 6, 7};
        //极端情况
//        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] nums = new int[]{3, -2, -3, 5, -2, 4, 3, -1, 5, 8};
        int k = 3;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }

    //    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        //pair[0]=num,pair[1]=index,大顶堆
//        PriorityQueue<int[]> queue = new PriorityQueue<>(
//                (pair1, pair2) -> pair2[0] - pair1[0]);
//        for (int i = 0; i < k; i++) {
//            queue.add(new int[]{nums[i], i});
//        }
//        int[] ans = new int[n - k + 1];
//        ans[0] = queue.peek()[0];
//        for (int i = k; i < n; i++) {
//            //当前考查范围:[i-k+1,i]
//            queue.add(new int[]{nums[i], i});
//            while (queue.peek()[1] <= i - k) {
//                //最大元素不在当前考查范围内,弹出
//                queue.poll();
//            }
//            //最大元素
//            ans[i - k + 1] = queue.peek()[0];
//        }
//        return ans;
//    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!list.isEmpty() && nums[list.getLast()] <= nums[i]) {
                list.removeLast();
            }
            list.addLast(i);
            //list.getFirst()最大值的下标
            if (list.getFirst() <= i - k) {
                list.removeFirst();
            }
            System.out.println(list);
            if (i - k + 1 >= 0) {
                ans[i - k + 1] = nums[list.getFirst()];
            }
        }
        return ans;
    }
}
