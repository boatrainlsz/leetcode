package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
 */
public class PermutationsMyWay {

    public static void main(String[] args) {
        PermutationsMyWay permutations = new PermutationsMyWay();
        System.out.println(permutations.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0) {
            return res;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                res.add(temp);
            }
        }
        return res;
    }

    /**
     * 作用：对深度为depth的树
     *
     * @param nums   数组
     * @param length 数组的长度
     * @param depth  当前递归到了第几层
     * @param path   当前的路径
     * @param used   数组中已被使用的数字
     * @param res    最后的结果
     */
    private void dfs(int[] nums, int length, int depth, Deque<Integer> path,
                     boolean[] used, List<List<Integer>> res) {
        if (depth == length) {
            //到达了叶子节点
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            //还未被使用
            if (!used[i]) {
                used[i] = true;
                path.addLast(nums[i]);
                //使用过了,继续下一层的递归
                dfs(nums, length, depth + 1, path, used, res);
                //下一层递归结束，撤销使用
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
