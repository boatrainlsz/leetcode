package com.boatrain.tree;

/**
 * <a href="https://leetcode.cn/problems/deepest-leaves-sum/">...</a>
 */
public class DeepestLeavesSum {
    int sum = 0;
    int currentDeepestLevel = 0;

    public int deepestLeavesSum(TreeNode root) {
        int currentLevel = 0;
        inOrder(root, currentLevel);
        return sum;
    }

    private void inOrder(TreeNode node, int currentLevel) {
        if (node == null) {
            return;
        }
        currentLevel++;
        if (currentLevel == currentDeepestLevel) {
            sum += node.val;
        } else if (currentLevel > currentDeepestLevel) {
            currentDeepestLevel = currentLevel;
            sum = node.val;
        }
        //左子树
        inOrder(node.left, currentLevel);
        //右子树
        inOrder(node.right, currentLevel);
    }
}
