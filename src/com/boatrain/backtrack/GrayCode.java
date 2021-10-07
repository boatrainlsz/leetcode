package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrayCode {
    public static void main(String[] args) {
        GrayCode solution = new GrayCode();
        System.out.println(solution.grayCode(6));

    }

    int pow;
    boolean[] used;
    List<Integer> ans = new ArrayList<>();

    public List<Integer> grayCode(int n) {
        long start = System.currentTimeMillis();
        pow = (int) Math.pow(2, n);
        used = new boolean[pow];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        used[0] = true;
        dfs(n, 0, path);
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start) / 1000 + " s");
        String str = "";
        for (int i = 0; i < ans.size() - 1; i++) {
            str += (ans.get(i) ^ ans.get(i + 1)) + ",";
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer an : ans) {
            countMap.merge(an, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() != 1) {
                System.out.println("found more than 1: " + entry.getKey());
            }
        }
        System.out.println(str);
        return ans;
    }

    private boolean dfs(int n, int depth, ArrayList<Integer> path) {
        if (depth == pow - 1) {
            Integer first = path.get(0);
            Integer last = path.get(path.size() - 1);
            int xor = first ^ last;
            if ((xor & (xor - 1)) == 0) {
                ans = new ArrayList<>(path);
                return true;
            }
            return false;
        }
        for (int i = 0; i < pow; i++) {
            if (!used[i]) {
                Integer adj = path.get(path.size() - 1);
                int xor = adj ^ i;
                if ((xor & (xor - 1)) == 0) {
                    path.add(i);
                    used[i] = true;
                    if (dfs(n, depth + 1, path)) return true;
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
        return false;
    }
}
