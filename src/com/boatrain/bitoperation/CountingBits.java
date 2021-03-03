package com.boatrain.bitoperation;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int highest = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highest = i;
                ans[i] = 1;
            } else {
                ans[i] = ans[i - highest] + 1;
            }
        }
        return ans;
    }
}