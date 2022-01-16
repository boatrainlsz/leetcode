package com.boatrain.linklist;

import java.util.LinkedList;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/linked-list-random-node
 */
class LinkedListRandomNode {
    LinkedList<Integer> list = new LinkedList<>();

    public LinkedListRandomNode(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
    }

    public int getRandom() {
        int l = 0, r = list.size();
        Random random = new Random();
        int index = random.nextInt(l + r);
        return list.get(index);
    }
}