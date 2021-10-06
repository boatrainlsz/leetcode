package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        find(candidates, target, 0, path);
        return ans;
    }

    private void find(int[] candidates, int target, int index, List<Integer> path) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (index == candidates.length) return;
        for (int i = 0; candidates[index] * i <= target; i++) {
            find(candidates, target - candidates[index] * i, index + 1, path);
            path.add(candidates[index]);
        }
        for (int i = 0; candidates[index] * i <= target; i++) {
            path.remove(path.size() - 1);
        }
    }
}
