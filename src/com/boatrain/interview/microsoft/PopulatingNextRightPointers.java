package com.boatrain.interview.microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 这一题和BinaryTreeLevelOrderTraversal都是采用层序遍历的方法
 */
public class PopulatingNextRightPointers {
    public static void main(String[] args) {
        PopulatingNextRightPointers solution = new PopulatingNextRightPointers();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};

//        System.out.println(solution.connect(solution.array2Tree(array)));
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node1.left=node2;
        node1.right = node3;
        System.out.println(solution.connect(node1));
    }

    private Node array2Tree(int[] array) {
        Node root = null;
        //todo

        return root;
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Node> levelNodes = new ArrayList<>();
            int levelSize = queue.size();
            //for循环的size要固定下来，而不能直接使用queue.size()，因为在循环中size一直在变的
            for (int i = 0; i < levelSize; i++) {
                Node poll = queue.poll();
                levelNodes.add(poll);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            //next
            for (int i = 0; i < levelNodes.size() - 1; i++) {
                levelNodes.get(i).next = levelNodes.get(i + 1);
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
