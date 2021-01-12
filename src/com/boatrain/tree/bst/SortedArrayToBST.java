package com.boatrain.tree.bst;

import com.boatrain.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        SortedArrayToBST solution = new SortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);
        System.out.println();
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return sortedArrayToBST(nums, 0, n - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + ((r - l) >> 1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, l, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, r);
        return node;
    }
}