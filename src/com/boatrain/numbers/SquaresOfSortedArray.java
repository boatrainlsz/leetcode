package com.boatrain.numbers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class SquaresOfSortedArray {
    public static void main(String[] args) {
        SquaresOfSortedArray solution = new SquaresOfSortedArray();
        int[] array = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(solution.sortedSquares(array)));
    }

    public int[] sortedSquares(int[] A) {
        Integer[] integers = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            integers[i] = A[i];
        }
        Arrays.sort(integers, Comparator.comparingInt(Math::abs));
        int[] result = new int[A.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = integers[i] * integers[i];
        }
        return result;
    }
}
