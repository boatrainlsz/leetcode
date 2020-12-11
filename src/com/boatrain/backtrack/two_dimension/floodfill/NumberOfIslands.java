package com.boatrain.backtrack.two_dimension.floodfill;

public class NumberOfIslands {
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited = new boolean[][]{};

    private int maxX;
    private int maxY;

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }

    /**
     * 未访问过的陆地节点为黄色，水域节点为蓝色，访问过的陆地节点为红色
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        maxX = grid.length;
        maxY = grid[0].length;
        visited = new boolean[maxX][maxY];
        int result = 0;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (isInArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
                dfs(grid, newX, newY);
            }
        }
        //没有visited[x][y] = false的过程，因为目的就是要将岛陆地节点部涂为红色
    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }
}
