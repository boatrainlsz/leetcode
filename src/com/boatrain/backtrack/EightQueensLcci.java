package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.List;

public class EightQueensLcci {
    List<List<String>> ans = new ArrayList<>();
    int n;
    boolean[] colMark, dia1, dia2;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        colMark = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        solve(0, new ArrayList<>());
        return ans;
    }

    private void solve(int row, List<Integer> cols) {
        if (row == n) {
            //
            add2Ans(cols);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!colMark[col] && !dia1[row + col]
                    && !dia2[row - col + n - 1]) {
                cols.add(col);
                colMark[col] = true;
                dia1[row + col] = true;
                dia2[row - col + n - 1] = true;
                solve(row + 1, cols);
                colMark[col] = false;
                dia1[row + col] = false;
                dia2[row - col + n - 1] = false;
                cols.remove(cols.size() - 1);
            }
        }
    }

    private void add2Ans(List<Integer> cols) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder str = new StringBuilder();
            Integer col = cols.get(i);
            for (int j = 0; j < cols.size(); j++) {
                if (j != col) {
                    str.append(".");
                } else {
                    str.append("Q");
                }
            }
            list.add(str.toString());
        }
        ans.add(list);
    }

}
