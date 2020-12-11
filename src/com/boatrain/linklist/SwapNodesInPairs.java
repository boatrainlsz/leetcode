package com.boatrain.linklist;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();
        int[] arr = new int[]{1, 2, 3, 4};
        ListNode head = new ListNode(arr[0]); // 把数组的第一个位置定义为头结点
        ListNode other = head; // 一个指针，此时指向头结点
        for (int i = 1; i < arr.length; i++) { //头结点已经定义，从1开始
            other.next = new ListNode(arr[i]);
            other = other.next;

        }
        ListNode listNode = solution.swapPairs(head);
        System.out.println(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur.next.next;
            cur.next.next  = next;
            cur = cur.next.next;
        }
        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
