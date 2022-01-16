package com.boatrain.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/solving-questions-with-brainpower/
 */
public class MostPoints {
    public long mostPoints(int[][] questions) {
        var n = questions.length;
        var f = new long[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = Math.max(f[i + 1], f[i]);
            var q = questions[i];
            var j = Math.min(i + q[1] + 1, n);
            f[j] = Math.max(f[j], f[i] + q[0]);
        }
        return f[n];
    }
}
