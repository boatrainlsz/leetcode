package com.boatrain.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
    private int maxX;
    private int maxY;

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        maxX = row;
        maxY = col;
        boolean[][] visited = new boolean[row][col];
        int i = 0;
        int j = 0;
        while (true) {
            if (!visited[i][j]) {
                result.add(matrix[i][j]);
                visited[i][j] = true;
            } else if (isInArea(i, j + 1) && !visited[i][j + 1]) {
                result.add(matrix[i][j + 1]);
                j++;
                visited[i][j] = true;
            } else if (isInArea(i, j - 1) && !visited[i][j - 1]) {
                result.add(matrix[i][j - 1]);
                j--;
                visited[i][j] = true;
            } else if (isInArea(i + 1, j) && !visited[i + 1][j]) {
                result.add(matrix[i + 1][j]);
                i++;
                visited[i][j] = true;
            } else if (isInArea(i - 1, j) && !visited[i - 1][j]) {
                result.add(matrix[i - 1][j]);
                i--;
                visited[i][j] = true;
            } else {
                break;
            }
            while (isInArea(i, j + 1) && !visited[i][j + 1]) {
                result.add(matrix[i][j + 1]);
                j++;
                visited[i][j] = true;
            }
            while (isInArea(i + 1, j) && !visited[i + 1][j]) {
                result.add(matrix[i + 1][j]);
                i++;
                visited[i][j] = true;
            }
            while (isInArea(i, j - 1) && !visited[i][j - 1]) {
                result.add(matrix[i][j - 1]);
                j--;
                visited[i][j] = true;
            }
            while (isInArea(i - 1, j) && !visited[i - 1][j]) {
                result.add(matrix[i - 1][j]);
                i--;
                visited[i][j] = true;
            }
        }
        return result;
    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }

}
