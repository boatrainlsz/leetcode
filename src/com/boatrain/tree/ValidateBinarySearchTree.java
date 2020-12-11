package com.boatrain.tree;

/**
 * 校验一棵树是不是二叉搜索树
 * 递归，小心陷阱，使用上下界来避免陷阱。
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST(root));
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer higher){
        if(root == null){
            return true;
        }
        if(lower!=null && root.val <= lower)
            return false;
        if(higher!=null && root.val >= higher)
            return false;
        if(!helper(root.left, lower,root.val))
            return false;
        if(!helper(root.right,root.val,higher))
            return false;

        return true;
    }
}
