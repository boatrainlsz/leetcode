package com.boatrain.linklist;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNode {
    public static void main(String[] args) {
        RemoveNthNode solution = new RemoveNthNode();

        System.out.println(solution.removeNthFromEnd(null, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode next = head;
        for (int i = 0; i < n; i++) {
            next = next.next;
        }
        while (next != null) {
            next = next.next;
            prev = prev.next;
        }
        //此时prev.next就是要删除的节点
        prev.next = prev.next.next;
        //不能返回head，而是dummyHead.next。考虑输入1,1这种情况
        return head;
    }

    public class ListNode {
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
