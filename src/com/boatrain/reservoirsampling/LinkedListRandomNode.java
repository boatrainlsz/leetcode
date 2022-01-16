package com.boatrain.reservoirsampling;

import com.boatrain.linklist.ListNode;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/linked-list-random-node
 */
class LinkedListRandomNode {
    ListNode head;
    Random random;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int i = 1, ans = 0;
        for (ListNode node = head; node != null; node = node.next) {
            if (random.nextInt(i) == 0) { // 1/i 的概率选中（替换为答案）
                ans = node.val;
            }
            ++i;
        }
        return ans;
    }
}