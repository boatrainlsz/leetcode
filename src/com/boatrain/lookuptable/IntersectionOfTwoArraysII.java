package com.boatrain.lookuptable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2,2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        //两个map分别统计数字出现的次数，将数字填充 最小出现次数 次
        Map<Integer, Integer> countMap1 = new HashMap<>();
        for (int j : nums1) {
            countMap1.merge(j, 1, Integer::sum);
            Arrays.fill(new int[]{},1,1,1);
        }
        Map<Integer, Integer> countMap2 = new HashMap<>();
        for (int j : nums2) {
            countMap2.merge(j, 1, Integer::sum);
        }
        int[] result = new int[countMap1.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : countMap1.entrySet()) {
            Integer freqIn1 = entry.getValue();
            Integer freqIn2 = countMap2.get(entry.getKey());
            if (freqIn2 != null) {
                int freq = Math.min(freqIn1, freqIn2);
                Arrays.fill(result, index, index + freq, entry.getKey());
                index += freq;
            }
        }
        return Arrays.copyOf(result, index);
    }

}
