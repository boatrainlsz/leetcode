package com.boatrain.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePathsII {

    private static int maxX;
    private static int maxY;
    private static Integer[][] pathCount;
    private static int[][] grid;

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 0, 1},
                {0, 0, 0}
        };
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        maxX = obstacleGrid.length;
        maxY = obstacleGrid[0].length;
        grid = obstacleGrid;
        if (grid[0][0] == 1) return 0;
        pathCount = new Integer[maxX][maxY];
        pathCount[0][0] = 1;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                calculatePathCount(i, j);
            }
        }
        return pathCount[maxX - 1][maxY - 1];
    }


    private boolean isInArea(int x, int y) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }

    private void calculatePathCount(int x, int y) {
        if (grid[x][y] == 1) {
            pathCount[x][y] = 0;
        } else if (isInArea(x - 1, y) && isInArea(x, y - 1)) {
            pathCount[x][y] = pathCount[x - 1][y] + pathCount[x][y - 1];
        } else if (isInArea(x - 1, y)) {
            //第一列
            pathCount[x][y] = pathCount[x - 1][y];
        } else if (isInArea(x, y - 1)) {
            //第一行
            pathCount[x][y] = pathCount[x][y - 1];
        }
    }
}
