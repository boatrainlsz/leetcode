package com.boatrain.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/summary-ranges/
 */
public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges solution = new SummaryRanges();
        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        System.out.println(solution.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        int n = nums.length;
        //i：增量为1的递增的起点，j：增量为1的递增的终点
        int i = 0, j = 0;
        while (j < n) {
            while (j + 1 < n && nums[j + 1] == nums[j] + 1) {
                j++;
            }
            StringBuilder start = new StringBuilder(Integer.toString(nums[i]));
            String end = Integer.toString(nums[j]);
            if (i == j) {
                ans.add(start.toString());
            } else {
                ans.add(start.append("->").append(end).toString());
            }
            //开始下一轮探索
            i = ++j;
        }
        return ans;
    }
}