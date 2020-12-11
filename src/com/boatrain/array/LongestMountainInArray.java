package com.boatrain.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 */
public class LongestMountainInArray {
    public static void main(String[] args) {
        System.out.println(new LongestMountainInArray().longestMountain(new int[]{2,2,2}));
    }

    public int longestMountain(int[] A) {
        //找山顶，向两边延伸
        //left[i]:A[i]左侧山脉的最大长度，right[i]:A[i]右侧山脉的最大长度
        //显然：left[0] = 0;right[A.length-1] = 0;
        int left[] = new int[A.length];
        int right[] = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i - 1] > A[i]) {
                right[i - 1] = right[i] + 1;
            }
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (left[i] > 0 && right[i] > 0)
                result = Math.max(result, left[i] + right[i] + 1);
        }
        return result;
    }

}
