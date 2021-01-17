package com.boatrain.array.matrix;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/largest-submatrix-with-rearrangements/
 */
public class LargestSubmatrixWithRearrangements {
    public static void main(String[] args) {
        LargestSubmatrixWithRearrangements solution = new LargestSubmatrixWithRearrangements();
        int[][] matrix = {{0, 0, 1}, {1, 1, 1}, {1, 0, 1}};
        System.out.println(solution.largestSubmatrix(matrix));
    }

    public int largestSubmatrix(int[][] matrix) {
        //改变了输入数据
        //matrix[i][j]:从matrix[i][j](包括自己)往上，连续的1的个数
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            //从小到大排序
            Arrays.sort(matrix[i]);
            for (int j = col - 1; j >= 0; j--) {
                //从后往前遍历
                //matrix[i][j]就是高，col - j就是宽
                ans = Math.max(ans, matrix[i][j] * (col - j));
                if (matrix[i][j] == 0) {
                    //高为0，再往前，高也都是0，没必要继续循环了
                    break;
                }
            }
        }
        return ans;
    }
}
