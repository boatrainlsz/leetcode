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
        if (intervals.length == 0) {
            return 0;
        }
        //按左端点升序排列
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int count = 0;
        //当前无重叠区间的右端点
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                //当前考察的区间和当前无重叠区间有交集，去除一个区间，去除哪个呢，去除右端点大的（也就是更新右端点为较小值）
                //因为区间越短越好
                count++;
                end = Math.min(end, intervals[i][1]);
            } else {
                //无交集，扩充当前无重叠区间的右端点
                end = intervals[i][1];
            }
        }
        return count;
    }
}