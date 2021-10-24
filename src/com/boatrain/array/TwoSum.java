package com.boatrain.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> lastMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            firstMap.putIfAbsent(nums[i], i);
            lastMap.put(nums[i], i);
        }
        for (int num : nums) {
            int index1 = firstMap.get(num);
            if (lastMap.containsKey(target - num)) {
                int index2 = lastMap.get(target - num);
                if (index2 != index1) {
                    return new int[]{index1, index2};
                }
            }
        }
        System.out.println(firstMap);
        System.out.println(lastMap);
        return null;
    }
}
