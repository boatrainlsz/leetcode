package com.boatrain.dualpointer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/degree-of-an-array/
 */
public class DegreeOfArray {
    public static void main(String[] args) {
        DegreeOfArray solution = new DegreeOfArray();
        int[] nums = new int[]{1, 2, 2, 3, 1};
        System.out.println(solution.findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        int ans = nums.length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1, i, i});
            } else {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }

        }
        ArrayList<int[]> list = new ArrayList<>(map.values());
        list.sort((arr1, arr2) -> arr1[0] == arr2[0] ? arr1[2] - arr1[1] - (arr2[2] - arr2[1]) : arr2[0] - arr1[0]);
        return list.get(0)[2] - list.get(0)[1] + 1;
    }

}