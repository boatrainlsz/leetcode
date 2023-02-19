package com.boatrain.array.matrix;

class Largest1BorderedSquare {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},

        };
        System.out.println(new Largest1BorderedSquare().largest1BorderedSquare(grid));
    }

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (grid[i - 1][j - 1] == 0) {
                    left[i][j] = 0;
                    up[i][j] = 0;
                } else {
                    left[i][j] = left[i][j - 1] + grid[i - 1][j - 1];
                    up[i][j] = up[i - 1][j] + grid[i - 1][j - 1];
                    int sideLength = Math.min(left[i][j], up[i][j]);
                    while (up[i][j - sideLength + 1] < sideLength || left[i - sideLength + 1][j] < sideLength) {
                        sideLength--;
                    }
                    ans = Math.max(ans, sideLength);
                }
            }
        }
        return ans * ans;
    }

}