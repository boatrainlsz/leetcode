package com.boatrain.linklist;

/**
 * https://leetcode-cn.com/problems/partition-list/
 */
public class PartitionList {
    public static void main(String[] args) {
        PartitionList solution = new PartitionList();
        ListNode head = LinkListUtil.arr2List(new int[]{1,4,3,2,5,2});
        System.out.println(solution.partition(head, 3));
    }

    public ListNode partition(ListNode head, int x) {
        return head;
    }
}
