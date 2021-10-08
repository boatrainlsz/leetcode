package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        GrayCode solution = new GrayCode();
        System.out.println(solution.grayCode(6));

    }

    int pow;
    boolean[] used;
    List<Integer> ans = new ArrayList<>();

    public List<Integer> grayCode(int n) {
        pow = 1 << n;
        used = new boolean[pow];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        used[0] = true;
        dfs(n, path);
        return ans;
    }

    private boolean dfs(int n, ArrayList<Integer> path) {
        if (path.size() == pow) {
            Integer first = path.get(0);
            Integer last = path.get(path.size() - 1);
            int xor = first ^ last;
            if ((xor & (xor - 1)) == 0) {
                ans = new ArrayList<>(path);
                return true;
            }
            return false;
        }
        for (int i = 0; i < n; i++) {
            Integer adj = path.get(path.size() - 1);
            int candidate = adj ^ (1 << i);
            if (!used[candidate]) {
                path.add(candidate);
                used[candidate] = true;
                if (dfs(n, path)) return true;
                path.remove(path.size() - 1);
                used[candidate] = false;
            }
        }
        return false;
    }
}
