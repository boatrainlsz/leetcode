package com.boatrain.backtrack.two_dimension;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 * 太平洋 ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * 大西洋
 */
//todo stackoverflowerror
public class PacificAtlanticWaterFlow {
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited = new boolean[][]{};

    private int maxX;
    private int maxY;

    public static void main(String[] args) {
        PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        int[][] matrix = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(solution.pacificAtlantic(matrix));
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        maxX = matrix.length;
        maxY = matrix[0].length;
        visited = new boolean[maxX][maxY];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (findPath2Pacific(matrix, i, j) && findPath2Atlantic(matrix, i, j)) {
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(j);
                    result.add(coordinate);
                }
            }
        }
        return result;
    }

    /**
     * 找到去往大西洋的路径
     *
     * @param matrix
     * @param x
     * @param y
     * @return
     */
    private boolean findPath2Atlantic(int[][] matrix, int x, int y) {
        visited[x][y] = true;
        //流向大西洋的递归终止条件
        if ((x == maxX - 1 || y == maxY - 1)) {
            visited[x][y] = false;
            return true;
        }
        for (int k = 0; k < 4; k++) {
            int newX = x + directions[k][0];
            int newY = y + directions[k][1];
            if (isInArea(newX, newY) && findPath2Atlantic(matrix, newX, newY) &&
                    matrix[newX][newY] <= matrix[x][y] && !visited[newX][newY]) {
                //流得动
                visited[x][y] = false;
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    /**
     * 找到去往太平洋的路径
     *
     * @param matrix
     * @param x
     * @param y
     * @return
     */
    private boolean findPath2Pacific(int[][] matrix, int x, int y) {
        visited[x][y] = true;
        //流向太平洋的递归终止条件
        if (x == 0 || y == 0) {
            visited[x][y] = false;
            return true;
        }
        for (int k = 0; k < 4; k++) {
            int newX = x + directions[k][0];
            int newY = y + directions[k][1];
            if (isInArea(newX, newY) && findPath2Pacific(matrix, newX, newY) &&
                    matrix[newX][newY] <= matrix[x][y] && !visited[newX][newY]) {
                //流得动
                visited[x][y] = false;
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }
}
