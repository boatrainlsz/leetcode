package com.boatrain.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 递归很简单，能否用迭代的方法得到结果？
 */
public class BinaryTreePreorderTraversal {
    List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode treeNode = new TreeNode(2);
        root.right = treeNode;
        treeNode.left = new TreeNode(3);
        System.out.println(solution.preorderTraversalIteratively(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        //前序遍历
        if (root != null) {
            result.add(root.val);
            if (root.left != null) {
                preorderTraversal(root.left);
            }
            if (root.right != null) {
                preorderTraversal(root.right);
            }
        }
        return result;
    }


    /**
     * 迭代前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalIteratively(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                result.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
