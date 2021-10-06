package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class PermutationsII {
    public static void main(String[] args) {
        PermutationsII solution = new PermutationsII();
        int[] nums = {1, 1, 2};
        System.out.println(solution.permuteUnique(nums));
    }

    List<List<Integer>> ans = new ArrayList<>();
    HashMap<Integer, Integer> countMap = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }
        dfs(nums, 0, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList(path));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 0) {
                path.add(entry.getKey());
                countMap.merge(entry.getKey(), -1, Integer::sum);
                dfs(nums, index + 1, path);
                path.remove(path.size() - 1);
                countMap.merge(entry.getKey(), 1, Integer::sum);
            }
        }
    }
}
