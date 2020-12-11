package com.boatrain.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {

    private static int maxX;
    private static int maxY;
    private static Integer[][] pathCount;
    private static int[][] grid;

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        maxX = m;
        maxY = n;
        grid = new int[m][n];
        pathCount = new Integer[m][n];
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (i == 0 || j == 0) {
                    pathCount[i][j] = 1;
                } else {
                    calculatePathCount(i, j);
                }
            }
        }
        return pathCount[maxX - 1][maxY - 1];
    }

    private void calculatePathCount(int x, int y) {
        pathCount[x][y] = pathCount[x - 1][y] + pathCount[x][y - 1];
    }
}
