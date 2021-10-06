package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PermutationsI {
    public static void main(String[] args) {
        PermutationsI solution = new PermutationsI();
        int[] nums = {1, 3, 2};
        System.out.println(solution.permute(nums));
    }

    boolean[] used;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, index + 1, path);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
