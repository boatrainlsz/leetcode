package com.boatrain.array;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/last-stone-weight/
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        LastStoneWeight solution = new LastStoneWeight();
        System.out.println(solution.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
                (o1, o2) -> o2 - o1);
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 0) {
            Integer max = maxHeap.poll();
            if (maxHeap.size() == 0) {
                return max;
            }
            Integer secondMax = maxHeap.poll();
            if (!secondMax.equals(max)) {
                maxHeap.add(max - secondMax);
            }
        }
        return 0;
    }
}
