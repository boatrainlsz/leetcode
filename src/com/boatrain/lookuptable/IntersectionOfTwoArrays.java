package com.boatrain.lookuptable;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/submissions/
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(nums1, nums2)));
    }

    /**
     * 我自己的解法
     * @param nums1
     * @param nums2
     * @return
     */
//    public int[] intersection(int[] nums1, int[] nums2) {
//        List<Integer> result = new ArrayList<>();
//        Map<Integer, Integer> indexMap = new HashMap<>();
//        for (int i = 0; i < nums1.length; i++) {
//            indexMap.putIfAbsent(nums1[i], i);
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            if (indexMap.get(nums2[i]) != null && !result.contains(nums2[i])) {
//                result.add(nums2[i]);
//            }
//        }
//        int[] arr = new int[result.size()];
//        for (int i = 0; i < result.size(); i++) {
//            arr[i] = result.get(i);
//        }
//        return arr;
//    }

    /**
     * 效率更高的解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        if (set1.size() < set2.size()) {
            return findInterSection(set1, set2);
        }
        return findInterSection(set2, set1);
    }

    private int[] findInterSection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] res = new int[set1.size()];
        int index = 0;
        for (Integer integer : set1) {
            if (set2.contains(integer)) {
                res[index++] = integer;
            }
        }
        return Arrays.copyOf(res, index);
    }
}
