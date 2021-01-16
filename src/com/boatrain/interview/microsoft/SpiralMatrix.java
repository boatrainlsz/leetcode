package com.boatrain.interview.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * 微软面试题
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
                //右边
                result.add(matrix[i][j + 1]);
                j++;
                visited[i][j] = true;
            }
            //左、下、上的判断可以去掉，因为向上的while结束后，下一步就是向右了
//            else if (isInArea(i, j - 1) && !visited[i][j - 1]) {
//                result.add(matrix[i][j - 1]);
//                j--;
//                visited[i][j] = true;
//            } else if (isInArea(i + 1, j) && !visited[i + 1][j]) {
//                result.add(matrix[i + 1][j]);
//                i++;
//                visited[i][j] = true;
//            } else if (isInArea(i - 1, j) && !visited[i - 1][j]) {
//                result.add(matrix[i - 1][j]);
//                i--;
//                visited[i][j] = true;
//            }
            else {
                //上下左右都遍历过了，结束循环
                break;
            }
            while (isInArea(i, j + 1) && !visited[i][j + 1]) {
                //向右
                result.add(matrix[i][j + 1]);
                j++;
                visited[i][j] = true;
            }
            while (isInArea(i + 1, j) && !visited[i + 1][j]) {
                //向下
                result.add(matrix[i + 1][j]);
                i++;
                visited[i][j] = true;
            }
            while (isInArea(i, j - 1) && !visited[i][j - 1]) {
                //向左
                result.add(matrix[i][j - 1]);
                j--;
                visited[i][j] = true;
            }
            while (isInArea(i - 1, j) && !visited[i - 1][j]) {
                //向上
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
