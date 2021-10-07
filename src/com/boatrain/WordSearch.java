package com.boatrain;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = new char[][]{{'a', 'a'}};
        String word = "aaa";
        System.out.println(solution.exist(board, word));
    }

    boolean[][] visited;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        char[] words = word.toCharArray();
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, words, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] words, int index) {
        if (board[i][j] != words[index]) {
            return false;
        }
        visited[i][j] = true;
        if (index == words.length - 1) return words[index] == board[i][j];
        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (inGrid(newX, newY) && !visited[newX][newY]) {
                if (dfs(board, newX, newY, words, index + 1)) return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    private boolean inGrid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
