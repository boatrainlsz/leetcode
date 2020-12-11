package com.boatrain.backtrack.two_dimension;

import java.util.Arrays;

public class SurroundedRegions {
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] forbidden = new boolean[][]{};

    private int maxX;
    private int maxY;

    public static void main(String[] args) {
//        char[][] word = new char[][]{
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };
        char[][] word = new char[][]{
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
        };
        SurroundedRegions regions = new SurroundedRegions();
        regions.solve(word);
        //打印结果
        for (int i = 0; i < word.length; i++) {
            System.out.println(Arrays.toString(word[i]));
        }
        for (int i = 0; i < regions.forbidden.length; i++) {
            System.out.println(Arrays.toString(regions.forbidden[i]));
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        maxX = board.length;
        maxY = board[0].length;
        forbidden = new boolean[maxX][maxY];
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                //标记禁止访问的O
                if (isEdgeO(board[i][j], i, j)) {
                    dfs(board, i, j);
                }
            }
        }
        //替换
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (board[i][j] == 'O' && !forbidden[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 是位于边界上的、还未被标记为禁止访问的O
     *
     * @param c
     * @param i
     * @param j
     * @return
     */
    private boolean isEdgeO(char c, int i, int j) {
        return (i == 0 || j == 0 || i == maxX - 1 || j == maxY - 1) && !forbidden[i][j] && c == 'O';
    }

    private void dfs(char[][] grid, int x, int y) {
        forbidden[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (isInArea(newX, newY) && !forbidden[newX][newY] && grid[newX][newY] == 'O') {
                dfs(grid, newX, newY);
            }
        }
    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }
}
