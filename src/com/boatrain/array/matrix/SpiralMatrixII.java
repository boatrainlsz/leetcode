package com.boatrain.array.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
        SpiralMatrixII solution = new SpiralMatrixII();
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
    }

    private int maxX;
    private int maxY;



    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        maxX = row;
        maxY = col;
        boolean[][] visited = new boolean[row][col];
        int i = 0;
        int j = 0;
        int cur = 1;
        while (true) {
            if (!visited[i][j]) {
                matrix[i][j] = cur ;
                cur++;
                visited[i][j] = true;
            } else if (isInArea(i, j + 1) && !visited[i][j + 1]) {
                //右边
                matrix[i][j + 1] = cur ;
                cur++;
                j++;
                visited[i][j] = true;
            }
            //左、下、上的判断可以去掉，因为向上的while结束后，下一步就是向右了
            else {
                //上下左右都遍历过了，结束循环
                break;
            }
            while (isInArea(i, j + 1) && !visited[i][j + 1]) {
                //向右
                matrix[i][j + 1] = cur ;
                cur++;
                j++;
                visited[i][j] = true;
            }
            while (isInArea(i + 1, j) && !visited[i + 1][j]) {
                //向下
                matrix[i + 1][j] = cur ;
                cur++;
                i++;
                visited[i][j] = true;
            }
            while (isInArea(i, j - 1) && !visited[i][j - 1]) {
                //向左
                matrix[i][j - 1] = cur ;
                cur++;
                j--;
                visited[i][j] = true;
            }
            while (isInArea(i - 1, j) && !visited[i - 1][j]) {
                //向上
                matrix[i - 1][j] = cur ;
                cur++;
                i--;
                visited[i][j] = true;
            }
        }
        return matrix;
    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }

}
