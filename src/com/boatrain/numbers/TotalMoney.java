package com.boatrain.numbers;

/**
 * https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank
 */
public class TotalMoney {
    public int totalMoney(int n) {
        int w = n / 7;
        int r = n % 7;
        return (7 * w * w + 49 * w) / 2 + (r * r + 2 * w * r + r) / 2;
    }
}
