package com.boatrain.tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 这一题和PopulatingNextRightPointers都是采用层序遍历的方法
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node20.left = node15;
        node20.right = node7;
        node3.left = node9;
        node3.right = node20;
        System.out.println(solution.levelOrder(node3));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            //当前层的元素个数
            int curLevelSize = queue.size();
            List<Integer> curLevelList = new ArrayList<>();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode poll = queue.poll();
                curLevelList.add(poll.val);
                //添加下一层元素
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(curLevelList);
        }
        return result;
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
