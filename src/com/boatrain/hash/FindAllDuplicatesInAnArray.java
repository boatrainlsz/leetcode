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
        /**
         * 如果没有重复，则整数n应该出现在位置n-1的地方，现在有重复，比如n重复了两次，那么按照下面这个算法，
         * n-1这个地方会被标记两次，这样就能检测出
         */
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