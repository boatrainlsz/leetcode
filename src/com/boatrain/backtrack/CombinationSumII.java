package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> ans = new ArrayList<>();
    HashMap<Integer, Integer> countMap = new HashMap<>();

    public static void main(String[] args) {
        CombinationSumII solution = new CombinationSumII();
//        int[] cadidates = {2, 5, 2, 1, 2};
        int[] cadidates = {10, 1, 2, 7, 6, 1, 5};
//        int[] cadidates = {1,1,1,1,1};
        int target = 8;
        System.out.println(solution.combinationSum2(cadidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for (int candidate : candidates) {
            countMap.merge(candidate, 1, Integer::sum);
        }
        List<Integer> path = new ArrayList<>();
        find(candidates, target, 0, path);
        return ans;
    }

    private void find(int[] candidates, int target, int index, List<Integer> path) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
//            for (Integer integer : path) {
//                countMap.merge(integer, -1, Integer::sum);
//            }
            ans.add(new ArrayList<>(path));
            return;
        }
        if (index == candidates.length) return;
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (countMap.get(candidate) > 0) {
                path.add(candidate);
                countMap.merge(candidate, -1, Integer::sum);
                find(candidates, target - candidate, i, path);
                countMap.merge(candidate, 1, Integer::sum);
                path.remove(path.size() - 1);
            }
        }
    }
}
