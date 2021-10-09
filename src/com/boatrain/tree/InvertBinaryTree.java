package com.boatrain.tree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null ||
                (root.left == null && root.right == null)) return root;
        doInvert(root);
        return root;
    }

    private void doInvert(TreeNode root) {
        if (root == null) return;
        doInvert(root.left);
        doInvert(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
