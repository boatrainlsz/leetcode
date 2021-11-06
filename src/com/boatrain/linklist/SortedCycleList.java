package com.boatrain.linklist;

/**
 * https://leetcode-cn.com/problems/4ueAj6/
 */
public class SortedCycleList {

    // Definition for a Node.
    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node cur = head;
        while (true) {
            if (cur.val <= insertVal && cur.next.val >= insertVal) {
                break;
            } else if (cur.val <= insertVal && cur.next.val <= insertVal) {
                break;
            } else if (cur.val >= insertVal && cur.next.val >= insertVal) {
                break;
            }
            cur = cur.next;
            if (cur == head) {
                break;
            }
        }
        Node newNode = new Node(insertVal);
        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }

}
