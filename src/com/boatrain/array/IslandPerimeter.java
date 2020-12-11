package com.boatrain.array;

public class IslandPerimeter {
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int maxX;
    private int maxY;

    public static void main(String[] args) {
        IslandPerimeter solution = new IslandPerimeter();
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(solution.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        maxX = grid.length;
        maxY = grid[0].length;
        int result = 0;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                //探索上下左右四个方向
                for (int k = 0; k < directions.length; k++) {
                    int newX = i + directions[k][0];
                    int newY = j + directions[k][1];
                    if (grid[i][j] == 1) {
                        if (inArea(newX, newY)) {
                            if (grid[newX][newY] == 0) {
                                //邻水+1
                                result++;
                            }
                        } else {
                            //边界+1
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;

    }
}
