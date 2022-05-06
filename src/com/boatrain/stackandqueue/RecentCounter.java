package com.boatrain.stackandqueue;

import java.util.ArrayDeque;

/**
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 */
class RecentCounter {
    private ArrayDeque<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.addLast(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your com.boatrain.stackandqueue.RecentCounter object will be instantiated and called as such:
 * com.boatrain.stackandqueue.RecentCounter obj = new com.boatrain.stackandqueue.RecentCounter();
 * int param_1 = obj.ping(t);
 */