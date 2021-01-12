package com.boatrain.tree;

/**
 * 根据数组构造完全二叉树
 */
public class Array2CompleteTree {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = createTree(array);
    }

    private static TreeNode createTree(int[] array) {
        TreeNode[] nodes = new TreeNode[array.length];
        for (int i = 0; i < array.length; i++) {
            nodes[i] = new TreeNode(array[i]);
        }
        //确认父子关系
        for (int i = 0; i < array.length / 2 ; i++) {
            nodes[i].left = nodes[2 * i + 1];
            nodes[i].right = nodes[2 * i + 2];
        }
        return nodes[0];
    }
}
