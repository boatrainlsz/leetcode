package com.boatrain.tree;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(0);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.left.right = new TreeNode(1);
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
//        System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(root));
        System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(root, 0));
    }

    private int sumOfLeftLeaves(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left, sum) + sumOfLeftLeaves(root.right, sum);
        return sum;
    }

    /**
     * 返回以root为根节点的树的所有左叶节点之和
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            //root.left是左叶节点
            sum += root.left.val + sumOfLeftLeaves(root.right);
            return sum;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
