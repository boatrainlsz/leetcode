package com.boatrain.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 */
public class FourSumII {
    public static void main(String[] args) {
        FourSumII solution = new FourSumII();
        int[] A = new int[]{-1, -1};
        int[] B = new int[]{-1, 1};
        int[] C = new int[]{-1, 1};
        int[] D = new int[]{1, -1};
        int count = solution.fourSumCount(A, B, C, D);
        System.out.println(count);
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> sumAB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                sumAB.merge(a + b, 1, Integer::sum);
            }
        }
        for (int c : C) {
            for (int d : D) {
                if (sumAB.get(-c - d) != null) {
                    count+=sumAB.get(-c-d);
                }
            }
        }
        return count;
    }
}
