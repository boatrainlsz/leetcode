package com.boatrain.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/merge-intervals/">...</a>
 */

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = new int[][]{
                {1, 4}, {2, 3}
        };
        System.out.println(Arrays.deepToString(mergeIntervals.merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        //按照左端点从小到大排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> ans = new ArrayList<>();
        int l = -1, r = -1;
        for (int[] current : intervals) {
            if (r < current[0]) {
                //无交集
                if (l != -1) ans.add(new int[]{l, r});
                l = current[0];
                r = current[1];
            } else {
                //否则延长
                r = Math.max(r, current[1]);
            }
        }
        if (l != -1) ans.add(new int[]{l, r});
        return ans.toArray(new int[][]{});
    }
}