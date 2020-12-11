package com.boatrain.stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class SmallestKLcci {
    public static void main(String[] args) {
        SmallestKLcci solution = new SmallestKLcci();
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        System.out.println(Arrays.toString(solution.smallestK(arr, 4)));
    }

    public int[] smallestK(int[] arr, int k) {
        if (arr == null) return arr;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            if (maxHeap.size() == k) {
                if (maxHeap.peek()!=null && num < maxHeap.peek()) {
                    maxHeap.remove();
                    maxHeap.offer(num);
                }
            } else {
                //还未满，继续添加元素
                maxHeap.offer(num);
            }
        }
        return heap2Array(maxHeap);
    }

    private int[] heap2Array(PriorityQueue<Integer> maxHeap) {
        int[] arr = new int[maxHeap.size()];
        List<Integer> list = new ArrayList<>(maxHeap);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
