package com.boatrain.array;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/elimination-game/
 * 用栈会超出内存限制
 */
public class EliminationGame {
    public static void main(String[] args) {
        EliminationGame solution = new EliminationGame();
        System.out.println(solution.lastRemainingWithStack(1));
    }

    public int lastRemainingWithStack(int n) {
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

    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;
        //int n = n;

        while (n > 1) {
            //从左边开始移除 or（从右边开始移除，数列总数为奇数）
            if (left || n % 2 != 0) {
                head += step;
            }
            step *= 2; //步长 * 2
            left = !left; //取反移除方向
            n /= 2; //总数 / 2
        }

        return head;
    }
}
