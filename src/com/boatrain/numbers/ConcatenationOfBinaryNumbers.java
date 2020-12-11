package com.boatrain.numbers;

/**
 * https://leetcode-cn.com/problems/concatenation-of-consecutive-binary-numbers/submissions/
 */
public class ConcatenationOfBinaryNumbers {
    private static final int mod = 1000000007;

    public static void main(String[] args) {
        ConcatenationOfBinaryNumbers solution = new ConcatenationOfBinaryNumbers();
        System.out.println(solution.concatenatedBinary(96569));
    }

    public int concatenatedBinary(int n) {
        long x = 0;
        int shift = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                shift++;
            }
            x = ((x << shift) + i) % mod;
        }
        return (int) x;
    }
}
