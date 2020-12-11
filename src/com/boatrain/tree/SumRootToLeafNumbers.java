package com.boatrain.tree;

public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        SumRootToLeafNumbers solution = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(solution.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int parentSum) {
        if (root == null) return 0;
        int temp = parentSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return temp;
        }
        return sumNumbers(root.left, temp) + sumNumbers(root.right, temp);
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
