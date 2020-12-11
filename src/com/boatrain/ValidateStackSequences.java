package com.boatrain;

import java.util.Stack;

/**
 * 栈的压入弹出序列
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4,5,3,2,1};
        int j = 0;
        for (int i : pushed) {
            stack.push(i);
            while(!stack.isEmpty() && stack.peek() == popped[j]) { // 循环判断与出栈
                stack.pop();
                j++;
            }
        }
        System.out.println(stack.isEmpty());
    }
}
