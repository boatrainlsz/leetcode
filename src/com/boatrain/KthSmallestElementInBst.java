package com.boatrain;

import com.boatrain.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 在bst中找第k小的元素
 * 方法1：递归中序遍历，BST的特性就是左<根<右，所以中序遍历的结果正好是升序。
 * 取第k-1个就是结果
 * 方法二：迭代，方法一需要遍历整棵树，而迭代可以在找到答案后即可停止
 */
public class KthSmallestElementInBst {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left=new TreeNode(3);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        System.out.println(new KthSmallestElementInBst().kthSmallestWithIteration(root,3));
    }


    //中序遍历树，得到中序遍历list inorder,则inorder[k - 1]则是要求的值
    public int kthSmallestWithInorder(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public int kthSmallestWithIteration(TreeNode root, int k) {
        LinkedList<TreeNode> list = new LinkedList<>();
        while (true) {
            while (root != null) {
                list.add(root);
                root = root.left;
            }
            root = list.removeLast();
            if (--k == 0){
                //找到了
                return root.val;
            }
            root =root.right;
        }
    }
}
