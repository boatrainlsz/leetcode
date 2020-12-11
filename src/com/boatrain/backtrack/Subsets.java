package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new Stack<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, Stack<Integer> path) {
        res.add(new ArrayList<>(path));

        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            System.out.println("当前处于第" + i + "层 " + "当前选择：" + nums[j] + " 当前路径：" + path + " 当前结果：" + res);
            backtrack(j + 1, nums, res, path);
            path.pop();
        }
    }
}