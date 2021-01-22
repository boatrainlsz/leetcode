package com.boatrain.interview.microsoft;


import com.boatrain.linklist.LinkListUtil;
import com.boatrain.linklist.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 有更好解法，看官方题解
 * 和这题一样的思路 {@link com.boatrain.numbers.AddToArrayFormOfInteger}
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l1 = LinkListUtil.arr2List(new int[]{2, 4, 9});
        ListNode l2 = LinkListUtil.arr2List(new int[]{5, 6, 4, 9});
        System.out.println(solution.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> list1 = new LinkedList<>();
        Deque<Integer> list2 = new LinkedList<>();
        ListNode cur = l1;
        while (cur != null) {
            list1.add(cur.val);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            list2.add(cur.val);
            cur = cur.next;
        }
        int size = Math.max(list1.size(), list2.size());
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
        int index1 = arr1.length - 1;
        while (!list1.isEmpty()) {
            arr1[index1--] = list1.removeFirst();
        }
        int index2 = arr2.length - 1;
        while (!list2.isEmpty()) {
            arr2[index2--] = list2.removeFirst();
        }
        int carry = 0;
        ListNode dummyHead = new ListNode(-1);
        cur = dummyHead;
        for (int i = size - 1; i >= 0; i--) {
            int sum = arr1[i] + arr2[i] + carry;
            /*if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }*/
            //上面这段逻辑可以用下面这段逻辑代替，我好菜！ :)
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        System.out.println(carry);
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummyHead.next;
    }

    /**
     * 官方题解，2021/1/17 已理解
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersBetter(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null || cur2 != null) {
            int add1 = cur1 == null ? 0 : cur1.val;
            int add2 = cur2 == null ? 0 : cur2.val;
            int sum = add1 + add2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}
