package com.boatrain.dfs;

public class Minesweeper {

    int[][] directions = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };
    int maxX;
    int maxY;
    boolean[][] visited;

    public char[][] updateBoard(char[][] board, int[] click) {
        maxX = board.length;
        maxY = board[0].length;
        visited = new boolean[maxX][maxY];
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            //规则1
            board[x][y] = 'X';
        } else if (board[x][y] == 'E') {
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        visited[x][y] = true;
        int mineCountByMySide = mineCountByMySide(board, x, y);
        if (mineCountByMySide != 0) {
            //规则3
            board[x][y] = (char) (mineCountByMySide + 48);
        } else {
            //规则2
            board[x][y] = 'B';
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inBoard(newX, newY) && !visited[newX][newY]) {
                    dfs(board, newX, newY);
                }
            }
        }
    }

    private int mineCountByMySide(char[][] board, int x, int y) {
        int count = 0;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (inBoard(newX, newY) && board[newX][newY] == 'M') {
                count++;
            }
        }
        return count;
    }

    private boolean inBoard(int x, int y) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }
}
