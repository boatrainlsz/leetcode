package com.boatrain.array;

/**
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/
 * 有一个二维矩阵A 其中每个元素的值为0或1。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * <p>
 * 输入：[
 *          [0,0,1,1],
 *          [1,0,1,0],
 *          [1,1,0,0]
 *      ]
 * 输出：39
 * 解释：
 * 转换为 [
 *          [1,1,1,1],
 *          [1,0,0,1],
 *          [1,1,1,1]
 *       ]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 */
public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {

    }

    public int matrixScore(int[][] A) {

        return -1;
    }
}
