package com.boatrain.dfs;

public class NumEnclaves {
    int m;
    int n;
    int ans;
    boolean[][] visited;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!visited[i][j] && grid[i][j] == 1) ans++;
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1]);
        }
    }
}
