package com.boatrain.interview.microsoft;

import java.util.Arrays;

class TicTacToe {
    private int[][] board;
    private int n;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        ticTacToe.move(1, 0, 1);
        ticTacToe.move(1, 1, 1);
        System.out.println(ticTacToe.move(1, 2, 1));
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (row == 2 && col == 1 && player == 1) {
            System.out.println(Arrays.deepToString(board));
        }
        for (int i = 0; i < n; i++) {
            boolean isRowIWin = true;
            for (int j = 1; j < n; j++) {
                if ((board[i][j] != board[i][j - 1]) || board[i][j] == 0 || board[i][j - 1] == 0) {
                    isRowIWin = false;
                    break;
                }
            }
            if (isRowIWin) {
                return board[i][0];
            }
        }

        for (int j = 0; j < n; j++) {
            boolean isColJWin = true;
            for (int i = 1; i < n; i++) {
                if ((board[i][j] != board[i - 1][j]) || board[i][j] == 0 || board[i - 1][j] == 0) {
                    isColJWin = false;
                    break;
                }
            }
            if (isColJWin) {
                return board[0][j];
            }
        }
        boolean isCrossIWin = true;
        boolean isCrossIIWin = true;
        for (int i = 1; i < n; i++) {
            if ((board[i - 1][i - 1] != board[i][i]) || board[i][i] == 0 || board[i - 1][i - 1] == 0) {
                isCrossIWin = false;
            }
            if ((board[i - 1][n - i] != board[i][n - 1 - i]) || board[i - 1][n - i] == 0 || board[i][n - 1 - i] == 0) {
                isCrossIIWin = false;
            }
        }
        if (isCrossIWin) {
            return board[0][0];
        }
        if (isCrossIIWin) {
            return board[0][n - 1];
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */