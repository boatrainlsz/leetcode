package com.boatrain.linklist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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