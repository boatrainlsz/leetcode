package com.boatrain;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/elimination-game/
 * 用栈会超出内存限制
 */
public class EliminationGame {
    public static void main(String[] args) {
        EliminationGame solution = new EliminationGame();
        System.out.println(solution.lastRemaining(1));
    }

    public int lastRemaining(int n) {
        if (n == 1 || n == 2) return n;
        Stack<Integer> stack1 = new Stack<>();
        for (int i = n; i > 0; i--) {
            stack1.push(i);
        }
        Stack<Integer> stack2 = new Stack<>();
        while (true) {
            while (!stack1.isEmpty()) {
                stack1.pop();
                if (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.size() == 1) {
                break;
            }
            while (!stack2.isEmpty()) {
                stack2.pop();
                if (stack2.size() > 0) {
                    stack1.push(stack2.pop());
                }
            }
            if (stack1.size() == 1) {
                break;
            }
        }
        return stack1.isEmpty() ? stack2.pop() : stack1.pop();
    }
}
