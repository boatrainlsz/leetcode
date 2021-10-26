package com.boatrain.array;

import java.util.HashMap;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i], i);
        }
        System.out.println(indexMap);
        for (int i = 0; i < nums1.length; i++) {
            int index = indexMap.get(nums1[i]) + 1;
            int target = -1;
            while (index < nums2.length) {
                if (nums2[index] > nums1[i]) {
                    target = nums2[index];
                    break;
                }
                index++;
            }
            ans[i] = target;
        }
        return ans;
    }
}
