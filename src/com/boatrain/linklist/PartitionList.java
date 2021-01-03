package com.boatrain.linklist;

/**
 * https://leetcode-cn.com/problems/partition-list/
 */
public class PartitionList {
    public static void main(String[] args) {
        PartitionList solution = new PartitionList();
        ListNode head = LinkListUtil.arr2List(new int[]{1, 4, 3, 2, 5, 2});
        System.out.println(solution.partition(head, 3));
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode greaterDummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode smallerDummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode greaterCur = greaterDummyHead;
        ListNode smallerCur = smallerDummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                smallerCur.next = new ListNode(cur.val);
                smallerCur = smallerCur.next;
            } else {
                greaterCur.next = new ListNode(cur.val);
                greaterCur = greaterCur.next;
            }
            cur = cur.next;
        }
        smallerCur.next = greaterDummyHead.next;
        return smallerDummyHead.next;
    }
}
