package com.boatrain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/single-number-iii/
 */
class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(Arrays.toString(singleNumber.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (countMap.get(nums[i]) == null) {
                countMap.put(nums[i], 1);
            } else {
                countMap.remove(nums[i]);
            }
        }
        int[] result = new int[countMap.size()];
        Object[] boxResult = countMap.keySet().toArray();
        for (int i = 0; i < boxResult.length; i++) {
            result[i] = (Integer) boxResult[i];
        }
        return result;
    }
}