package com.boatrain.array.matrix;

/*
* https://leetcode.cn/problems/largest-local-values-in-a-matrix/
 */
public class LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - 2][n - 2];
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int max = 0;
                for (int k = i; k <= i + 2; k++) {
                    for (int l = j; l <= j + 2; l++) {
                        max = Math.max(max, grid[k][l]);
                    }
                }
                ans[i][j] = max;
            }
        }
        return ans;
    }
}