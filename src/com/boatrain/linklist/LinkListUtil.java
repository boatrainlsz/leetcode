package com.boatrain.linklist;

public class LinkListUtil {
    public static ListNode arr2List(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummyHead;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
