package com.boatrain.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/candy/
 */
public class Candy {

    public static void main(String[] args) {
        Candy candy = new Candy();
        System.out.println(candy.candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
    }

    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}
