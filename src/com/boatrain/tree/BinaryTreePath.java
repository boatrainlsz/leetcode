package com.boatrain.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class BinaryTreePath {
    //返回root到叶子节点的路径
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            //到达叶子节点
            res.add(String.valueOf(root.val));
            return res;
        }
        List<String> leftRes = binaryTreePaths(root.left);
        for (String left : leftRes) {
            res.add(root.val + "->" + left);
        }
        List<String> rightRes = binaryTreePaths(root.right);
        for (String right : rightRes) {
            res.add(root.val + "->" + right);
        }
        return res;
    }
}
