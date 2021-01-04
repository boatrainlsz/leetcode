package com.boatrain.dynamicprogramming;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(6));
    }

    public int fib(int n) {
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

}
