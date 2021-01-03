package com.boatrain.linklist;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        //从栈构造出反转的链表
        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        cur = dummyHead;
        while (!stack.isEmpty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        ListNode reverseHead = dummyHead.next;

        cur = head;
        ListNode reverseCur = reverseHead;
        //比较二者是否是一样的
        while (cur != null && reverseCur != null) {
            if (cur.val != reverseCur.val) return false;
            cur = cur.next;
            reverseCur = reverseCur.next;
        }
        return true;
    }
}
