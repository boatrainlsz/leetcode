package com.boatrain.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/Ygoe9J/
 */
public class CombinationSum {
    public static void main(String[] args) {

    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] c, int target) {
        int index = 0;
        List<Integer> path = new ArrayList<>();
        find(c, index, target, path);
        return ans;
    }

    private void find(int[] c, int index, int target, List<Integer> path) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < c.length; i++) {
            path.add(c[i]);
            find(c, i, target - c[i], path);
            path.remove(path.size() - 1);
        }
    }
}
