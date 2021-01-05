package com.boatrain.dynamicprogramming;

import java.util.Arrays;

public class FibonacciNumber {

    int[] memo = new int[]{};

    public static void main(String[] args) {
        FibonacciNumber solution = new FibonacciNumber();
        System.out.println(solution.fib(0));
    }

    /**
     * 循环
     *
     * @param n
     * @return
     */
    public int fibWithIter(int n) {
        if (n <= 1) return n;
        int fibN_1 = 1;
        int fibN_2 = 0;
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibN_1 + fibN_2;
            fibN_2 = fibN_1;
            fibN_1 = fibN;
        }
        return fibN;

    }

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        return fibWithMemo(n);
    }

    private int fibWithMemo(int n) {
        if (memo[n] == -1) {
            memo[n] = fibWithMemo(n - 1) + fibWithMemo(n - 2);
        }
        return memo[n];
    }
}
