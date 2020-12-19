package com.boatrain.array;

public class RotateImage {
    public static void main(String[] args) {
        RotateImage solution = new RotateImage();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(matrix);
        System.out.println(matrix);
    }

    public void rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[matrix.length - 1 - j][i];
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}