package com.boatrain.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        NonOverlappingIntervals solution = new NonOverlappingIntervals();
        int[][] intervals = new int[][]{
                {1, 100}, {11, 22}, {1, 11}, {2, 12}
        };
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new LeftComparator());
        int[] dp = new int[intervals.length];
        dp[0] = 1;
        for (int i = 1; i < intervals.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (!isOverLapped(intervals[j], intervals[i])) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
        }
        System.out.println(Arrays.toString(dp));
        return intervals.length - dp[dp.length - 1];
    }

    private boolean isOverLapped(int[] prev, int[] cur) {
        return cur[0] < prev[1];
    }


    class LeftComparator implements Comparator<int[]> {


        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }
}
