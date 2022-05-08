package com.boatrain.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-duplicates-in-an-array/
 */
public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new FindAllDuplicatesInAnArray().findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                ans.add(Math.abs(num));
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }

        }
        return ans;
    }
}