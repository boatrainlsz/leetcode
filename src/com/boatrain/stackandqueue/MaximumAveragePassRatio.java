package com.boatrain.stackandqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    public static void main(String[] args) {
        MaximumAveragePassRatio solution = new MaximumAveragePassRatio();
        int[][] classes = new int[][]
                {
                        {583, 868}, {783, 822}, {65, 262}, {121, 508}, {461, 780}, {484, 668}
                };
        int extraStudents = 8;
        System.out.println(solution.maxAverageRatio(classes, extraStudents));
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer classNo1, Integer classNo2) {
                long a1 = classes[classNo1][1];
                long b1 = classes[classNo1][0];
                long a2 = classes[classNo2][1];
                long b2 = classes[classNo2][0];
                long var1 = (a2 - b2) * a1 * (a1 + 1);
                long var2 = (a1 - b1) * a2 * (a2 + 1);
                if (var1 == var2) {
                    return 0;
                }
                return var1 < var2 ? -1 : 1;
            }
        });
        for (int i = 0; i < classes.length; i++) {
            maxHeap.add(i);
        }
        for (int i = 0; i < extraStudents; i++) {
            Integer maxDeltaClassNo = maxHeap.poll();
            classes[maxDeltaClassNo][0]++;
            classes[maxDeltaClassNo][1]++;
            maxHeap.add(maxDeltaClassNo);
        }
        double ans = 0;
        while (!maxHeap.isEmpty()) {
            int classNo = maxHeap.poll();
            ans += classes[classNo][0] * 1.0 / classes[classNo][1];
        }
        return ans / classes.length;
    }
}