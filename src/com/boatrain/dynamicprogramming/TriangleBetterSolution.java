package com.boatrain.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 */
public class TriangleBetterSolution {
    int result = Integer.MAX_VALUE;
    Integer[] minArray = new Integer[]{};

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> level1 = new ArrayList<>();
        level1.add(2);
        List<Integer> level2 = new ArrayList<>();
        level2.add(3);
        level2.add(4);
        List<Integer> level3 = new ArrayList<>();
        level3.add(6);
        level3.add(5);
        level3.add(7);
        List<Integer> level4 = new ArrayList<>();
        level4.add(4);
        level4.add(1);
        level4.add(8);
        level4.add(3);
        triangle.add(level1);
        triangle.add(level2);
        triangle.add(level3);
        triangle.add(level4);
        System.out.println(new TriangleBetterSolution().minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        minArray = new Integer[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                minArray[j] = findMin(triangle, i, j);
            }
        }
        for (int i = 0; i < minArray.length; i++) {
            if (minArray[i] < result) result = minArray[i];
        }
        return result;
    }

    private int findMin(List<List<Integer>> triangle, int i, int j) {
        if (i == 0 && j == 0) {
            return triangle.get(0).get(0);
        }
        if (j == 0) {
            return findMin(triangle, i - 1, j) + triangle.get(i).get(j);
        }
        if (i == j) return findMin(triangle, i - 1, j - 1) + triangle.get(i).get(j);
        return Math.min(findMin(triangle, i - 1, j), findMin(triangle, i - 1, j - 1)) + triangle.get(i).get(j);
    }
}
