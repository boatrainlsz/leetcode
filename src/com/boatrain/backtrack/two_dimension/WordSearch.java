package com.boatrain.backtrack.two_dimension;

/**
 * https://leetcode-cn.com/problems/word-search/
 */
public class WordSearch {
    /**
     * 分别代表上右下左的坐标偏移量
     */
    int[][] direction = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    /**
     * 是否被访问过，已访问过的不能回头再访问
     */
    boolean[][] visited = new boolean[][]{};
    /**
     * 矩阵的行数
     */
    int maxX;
    /**
     * 矩阵的列数
     */
    int maxY;

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        String word = "ABCCED";
        System.out.println(new WordSearch().exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        //board[i][j]控制坐标
        maxX = board.length;
        maxY = board[0].length;
        visited = new boolean[maxX][maxY];
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (doCheck(board, i, j, word.toCharArray(), 0)) return true;
            }
        }
        return false;
    }

    /**
     * 在矩阵board中，以board[x,y]为起点，看是否能找到words[index...end]
     *
     * @param board
     * @param x
     * @param y
     * @param words
     * @param index
     * @return
     */
    private boolean doCheck(char[][] board, int x, int y, char[] words, int index) {
        //递归终止条件
        if (index == words.length - 1) {
            return board[x][y] == words[index];
        }
        if (board[x][y] == words[index]) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + direction[i][0];
                int newY = y + direction[i][1];
                //下一个要访问的点还在矩阵中且未访问过
                if (isInArea(newX, newY) && !visited[newX][newY]) {
                    if (doCheck(board, newX, newY, words, index + 1)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    /**
     * 下标是否越界
     *
     * @param newX
     * @param newY
     * @return
     */
    private boolean isInArea(int newX, int newY) {
        return newX >= 0 && newX < maxX && newY >= 0 && newY < maxY;
    }
}
