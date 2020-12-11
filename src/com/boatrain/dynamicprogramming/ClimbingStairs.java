package com.boatrain.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {
    int[] memo = new int[]{};

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.climbStairs(100));
    }

    public int climbStairs(int n) {
        if (n == 2 || n == 1) {
            return n;
        }
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[1] = 1;
        memo[2] = 2;
        return climb(n);
    }

    private int climb(int n) {
        if (memo[n] == -1) {
            memo[n] = climb(n - 1) + climb(n - 2);
        }
        return memo[n];
    }
}
