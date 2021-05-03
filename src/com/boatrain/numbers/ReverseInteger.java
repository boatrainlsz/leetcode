package com.boatrain.numbers;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1534236469));
    }

    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        return (int) ans;
    }
}