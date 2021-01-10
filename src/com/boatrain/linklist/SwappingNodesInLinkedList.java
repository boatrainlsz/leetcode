package com.boatrain.linklist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/
 * 应该可以用前后指针的算法写出来
 */
public class SwappingNodesInLinkedList {
    public static void main(String[] args) {
        SwappingNodesInLinkedList solution = new SwappingNodesInLinkedList();
        ListNode listNode = LinkListUtil.arr2List(new int[]{1, 2});
        System.out.println(solution.swapNodes(listNode, 1));
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        List<Integer> list = new ArrayList<>();
        while (cur.next != null) {
            list.add(cur.next.val);
            cur = cur.next;
        }
        Collections.swap(list, k - 1, list.size() - k);
        cur = dummyHead;
        for (int i = 0; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return dummyHead.next;
    }
}