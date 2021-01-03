package com.boatrain.linklist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String str = "";
        ListNode cur = this;
        while (cur != null) {
            str += cur.val + "->";
            cur = cur.next;
        }
        str += "NULL";
        return str;
    }
}