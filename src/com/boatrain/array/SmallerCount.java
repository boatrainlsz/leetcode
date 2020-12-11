package com.boatrain.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 */
public class SmallerCount {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SmallerCount()
                .smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] array = new int[101];
        for (int i = 0; i < nums.length; i++) {
            array[nums[i]]++;
        }
        System.out.println(Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i] + array[i - 1];
        }
        System.out.println(Arrays.toString(array));
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = nums[i] == 0 ? 0 : array[nums[i] - 1];
        }
        return ret;
    }
}
