package com.boatrain.array;

import java.util.Arrays;

public class WhereWillTheBallFall {
    public static void main(String[] args) {
        WhereWillTheBallFall soluton = new WhereWillTheBallFall();
        int[][] grid = new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
        System.out.println(Arrays.toString(soluton.findBall(grid)));
    }

    public int[] findBall(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] ans = new int[col];
        for (int i = 0; i < col; i++) {
            int curCol = i;
            for (int j = 0; j < row; j++) {
                if (grid[j][curCol] == 1) {
                    if (curCol != col - 1 && grid[j][curCol + 1] != -1) {
                        curCol++;
                    } else {
                        ans[i] = -1;
                        break;
                    }
                } else if (grid[j][curCol] == -1) {
                    if (curCol != 0 && grid[j][curCol - 1] != 1) {
                        curCol--;
                    } else {
                        ans[i] = -1;
                        break;
                    }
                }
                if (j == row - 1) {
                    ans[i] = curCol;
                }
            }
        }
        return ans;
    }
}
