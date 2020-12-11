package com.boatrain.backtrack.two_dimension;

import java.util.Arrays;

/**
 * 提交会超时，对于 有一大片连接到边界的O的情况，确实很慢
 * 而SurroundedRegions这种解法就能把这一大片全消灭掉。
 */
public class SurroundedRegionsMyWay {
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited = new boolean[][]{};

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
        SurroundedRegionsMyWay regions = new SurroundedRegionsMyWay();
        regions.solve(word);
        //打印结果
        System.out.println("最后的结果：");
        print(word);
        for (int i = 0; i < regions.visited.length; i++) {
            System.out.println(Arrays.toString(regions.visited[i]));
        }
    }

    private static void print(char[][] word) {
        for (int i = 0; i < word.length; i++) {
            System.out.println(Arrays.toString(word[i]));
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        maxX = board.length;
        maxY = board[0].length;
        visited = new boolean[maxX][maxY];
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                //如果是O且没有O路通往边界
                if (board[i][j] == 'O' && !dfs(board, i, j)) {
                    System.out.println("i=" + i + ", j=" + j);
                    board[i][j] = 'X';
                    print(board);
                }
            }
        }

    }


    /**
     * 从i,j开始是否可以找出一条O路直通边界
     *
     * @param board
     * @param x
     * @param y
     * @return
     */
    private boolean dfs(char[][] board, int x, int y) {
        visited[x][y] = true;
        //先尝试设置为X
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (isInArea(newX, newY) && !visited[newX][newY] && board[newX][newY] == 'O') {
                if (dfs(board, newX, newY)) {
                    //要撤销访问
                    visited[x][y] = false;
                    return true;
                }
            } else if (!isInArea(newX, newY) && board[x][y] == 'O') {
                //要撤销访问
                visited[x][y] = false;
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }
}
