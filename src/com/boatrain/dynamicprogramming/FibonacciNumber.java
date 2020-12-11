package com.boatrain.dynamicprogramming;

import java.util.Arrays;

public class FibonacciNumber {

    int[] memo = new int[]{};

    public static void main(String[] args) {
        FibonacciNumber solution = new FibonacciNumber();
        System.out.println(solution.fib(0));
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
