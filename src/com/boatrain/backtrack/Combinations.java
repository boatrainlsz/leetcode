package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        //从[1,n]中找出所有可能的k个数的组合
        //特殊条件判断
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        findCombinations(n, k, 1, new Stack<Integer>());
        return res;
    }

    private void findCombinations(int n, int k, int start, Stack<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            findCombinations(n, k, i + 1, path);
            path.pop();
        }
    }
}
