package com.boatrain.array.math;

/**
 * https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 */
public class CheckStraightLine {
    public static void main(String[] args) {
        CheckStraightLine solution = new CheckStraightLine();
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(solution.checkStraightLine(coordinates));
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int offsetX = coordinates[0][0];
        int offsetY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= offsetX;
            coordinates[i][1] -= offsetY;
        }
        int A = coordinates[1][1];
        int B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            if (coordinates[i][0] * A + coordinates[i][1] * B != 0) {
                return false;
            }
        }
        return true;
    }
}