package com.boatrain.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class PerfectSquares {

    public static void main(String[] args) {
        PerfectSquares solution = new PerfectSquares();
        System.out.println(solution.numSquares(13));
    }

    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        //依次求出 1, 2... 直到 n 的解
        for (int i = 1; i <= n; i++) {
            //依次减去一个平方数
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
