package com.boatrain.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 * 1
 * 11
 * 121
 * 1331
 * 14641
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle solution = new PascalsTriangle();
        System.out.println(solution.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Integer[] lastRow = new Integer[1];
        lastRow[0] = 1;
        result.add(Arrays.asList(lastRow));
        for (int i = 2; i <= numRows; i++) {
            Integer[] row = new Integer[i];
            //第一个和最后一个设置为1
            row[0] = 1;
            row[i - 1] = 1;
            //其余的根据递推关系推导
            for (int j = 1; j < i - 1; j++) {
                row[j] = lastRow[j] + lastRow[j - 1];
            }
            lastRow = row;
            result.add(Arrays.asList(row));
        }
        return result;
    }

}
