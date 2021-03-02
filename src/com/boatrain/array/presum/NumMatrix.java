package com.boatrain.array.presum;

class NumMatrix {
    private int m;
    private int n;
    private int[][] preSum;


    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        if (m == 0) {
            return;
        }
        n = matrix[0].length;
        preSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            preSum[i][0] = matrix[i][0];

            for (int j = 1; j < n; j++) {
                preSum[i][j] = preSum[i][j - 1] + matrix[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                preSum[i][j] += preSum[i - 1][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return preSum[row2][col2];
        }
        if (row1 == 0) {
            return preSum[row2][col2] - preSum[row2][col1 - 1];

        }
        if (col1 == 0) {
            return preSum[row2][col2] - preSum[row1 - 1][col2];

        }
        return preSum[row2][col2] - preSum[row1 - 1][col2] - preSum[row2][col1 - 1] + preSum[row1 - 1][col1 - 1];
    }
}