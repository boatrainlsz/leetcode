package com.boatrain.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePathsNewWay {
    public static void main(String[] args) {
        System.out.println(new UniquePathsNewWay().C(5, 3));
    }

    int C(int n, int m) {
        int res = 1, j = 1;
        for (int i = 0; i < m; i++) {
            res *= (n - i);
            while (j <= m && res % j == 0) {    //能除先除，避免溢出
                res /= j;
                System.out.println("n=" + n + ",m=" + m + " ,i=" + i + ", j=" + j + ", res=" + res);
                j++;
            }
        }
        return res;
    }

    int uniquePaths(int m, int n) {
        return C(m + n - 2, (Math.min(m, n)) - 1);    //取较小者作为C(n,m)中的m
    }
}
