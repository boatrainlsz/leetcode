package com.boatrain.stackandqueue;

import com.boatrain.array.MissingNumber;
import com.sun.source.tree.ReturnTree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

/*
https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/
* */
public class MinimumAmountOfTimeToFillCups {
    public static void main(String[] args) {
        MinimumAmountOfTimeToFillCups solution = new MinimumAmountOfTimeToFillCups();
        System.out.println(solution.fillCups(new int[]{12, 11, 1}));
    }

    public int fillCups(int[] amount) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(amount).forEach(maxHeap::add);
        int count = 0;
        while (true) {
            //最大的两个数
            int water1 = maxHeap.poll();
            int water2 = maxHeap.poll();
            if (water1 == 0 && water2 == 0 && maxHeap.peek() == 0) {
                break;
            }
            water1 = Math.max(water1 - 1, 0);
            water2= Math.max(water2 - 1, 0);
            maxHeap.add(water1);
            maxHeap.add(water2);
            count++;
        }
        return count;
    }
}