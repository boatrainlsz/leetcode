package com.boatrain.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
    Integer[][] minSumMatrix = new Integer[][]{};
    int maxX = 0;
    int maxY = 0;

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new MinimumPathSum().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        maxX = grid.length;
        maxY = grid[0].length;
        minSumMatrix = new Integer[maxX][maxY];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                minSumMatrix[i][j] = findMinPathSum(grid, i, j);
            }
        }
        return minSumMatrix[maxX - 1][maxY - 1];
    }

    private Integer findMinPathSum(int[][] grid, int i, int j) {
        if (i == j && i == 0) {
            return grid[i][j];
        }
        if (j == 0) {
            return minSumMatrix[i - 1][0] + grid[i][j];
        }
        if (i == 0) {
            return minSumMatrix[0][j - 1] + grid[i][j];
        }
        return Math.min(minSumMatrix[i - 1][j], minSumMatrix[i][j - 1]) + grid[i][j];
    }
}
