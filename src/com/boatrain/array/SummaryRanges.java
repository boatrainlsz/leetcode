package com.boatrain.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges solution = new SummaryRanges();
        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        System.out.println(solution.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        //i：增量为1的递增的起点，j：增量为1的递增的终点
        int i = 0, j = 0;
        while (j < n) {
            while (j + 1 < n && nums[j + 1] == nums[j] + 1) {
                j++;
            }
            String start = String.valueOf(nums[i]);
            String end = String.valueOf(nums[j]);
            if (i == j) {
                ans.add(start);
            } else {
                ans.add(start + "->" + end);
            }
            //开始下一轮探索
            i = ++j;
        }
        return ans;
    }
}