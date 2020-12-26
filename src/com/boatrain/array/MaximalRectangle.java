package com.boatrain.array;

/**
 * https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        MaximalRectangle solution = new MaximalRectangle();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(solution.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        //连续的1的个数
        int[][] consecutive1Cnt = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    consecutive1Cnt[i][j] = (j == 0 ? 0 : consecutive1Cnt[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int width = consecutive1Cnt[i][j];
                    //宽*长
                    int area = width;
                    for (int k = i - 1; k >= 0; k--) {
                        width = Math.min(width, consecutive1Cnt[k][j]);
                        area = Math.max(area, (i - k + 1) * width);
                    }
                    ret = Math.max(ret, area);
                }
            }
        }
        return ret;
    }
}