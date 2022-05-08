package com.boatrain.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-duplicates-in-an-array/
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
            if (count.get(num) == 2) {
                ans.add(num);
            }
        }
        return ans;
    }
}