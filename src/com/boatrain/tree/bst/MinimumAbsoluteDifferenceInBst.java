package com.boatrain.tree.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBst solution = new MinimumAbsoluteDifferenceInBst();
        TreeNode treeNode = new TreeNode(543);
        TreeNode treeNode1 = new TreeNode(384);
        TreeNode treeNode2 = new TreeNode(652);
        TreeNode treeNode3 = new TreeNode(445);
        TreeNode treeNode4 = new TreeNode(699);
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        System.out.println(solution.getMinimumDifference(treeNode));
    }

    public int getMinimumDifference(TreeNode root) {
        //麻烦的解法
       /* List<Integer> list = new ArrayList<>();
        getMinimumDifference(root, list);
        int result = Integer.MAX_VALUE;
        for (Integer integer : list) {
            result = Math.min(result, integer);
        }
        return result;*/

        //中序遍历，简单
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            result = Math.min(result, list.get(i + 1) - list.get(i));
        }
        return result;
    }


    /**
     * 解法一：算出所有节点的答案，再取这些答案的最小值
     * @param root
     * @param list
     */
    public void getMinimumDifference(TreeNode root, List<Integer> list) {
        int result = Integer.MAX_VALUE;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            //一直到root左子树的最右叶子，最右叶子是左子树中最大的
            TreeNode cur = left;
            while (cur.right != null) {
                cur = cur.right;
            }
            result = Math.min(root.val - cur.val, result);
        }
        if (right != null) {
            //一直到root右子树的最左叶子，最左叶子是右子树中最小的
            TreeNode cur = right;
            while (cur.left != null) {
                cur = cur.left;
            }
            result = Math.min(cur.val - root.val, result);
        }
        list.add(result);
        //递归求出
        if (left != null) {
            getMinimumDifference(left,list);
        }
        if (right != null) {
            getMinimumDifference(right,list);
        }
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null) {
            inorder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorder(root.right, list);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
