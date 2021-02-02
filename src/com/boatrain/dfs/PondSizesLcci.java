package com.boatrain.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PondSizesLcci {
    private boolean[][] visited;
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    private int MAX_X;
    private int MAX_Y;
    private List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        PondSizesLcci solution = new PondSizesLcci();
        int[][] land = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        System.out.println(Arrays.toString(solution.pondSizes(land)));
        System.out.println();
    }

    public int[] pondSizes(int[][] land) {
        int row = land.length;
        if (row == 0) return null;
        int col = land[0].length;
        if (col == 0) return null;
        MAX_X = row;
        MAX_Y = col;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && land[i][j] == 0) {
                    res.add(dfs(land, i, j));
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }

    private int dfs(int[][] land, int i, int j) {
        int res = 1;
        visited[i][j] = true;
        for (int k = 0; k < directions.length; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (isInArea(newX, newY) && !visited[newX][newY] && land[newX][newY] == 0) {
                visited[newX][newY] = true;
                res += dfs(land, newX, newY);
            }
        }
        return res;
    }

    private boolean isInArea(int i, int j) {
        return i >= 0 && i < MAX_X && j >= 0 && j < MAX_Y;
    }
}