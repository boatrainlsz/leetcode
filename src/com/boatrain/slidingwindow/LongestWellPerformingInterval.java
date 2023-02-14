package com.boatrain.slidingwindow;

import java.util.Stack;

public class LongestWellPerformingInterval {
    public static void main(String[] args) {
        LongestWellPerformingInterval solution = new LongestWellPerformingInterval();
        System.out.println(solution.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        System.out.println(solution.longestWPI(new int[]{6, 6, 9}));
        System.out.println(solution.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}));
    }

    public int longestWPI(int[] hours) {
        int n = hours.length;
        int ans = 0;
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = hours[i] > 8 ? 1 : -1;
        }
        int[] presum = new int[n + 1];
        presum[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            presum[i] = presum[i - 1] + score[i - 1];
        }
//        求解最长的[l,r]，使得presum[r]-presum[l]>0
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n + 1; i++) {
            if (stack.isEmpty() || presum[i] < presum[stack.peek()]) {
                stack.push(i);
            }
        }

        for (int i = n; i > ans; i--) {
            while (!stack.isEmpty() && presum[i] > presum[stack.peek()]) {
                ans = Math.max(ans, i - stack.peek());
                stack.pop();
            }
        }
        return ans;
    }
}