package com.boatrain.stackandqueue;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        int calculate = basicCalculatorII.calculate("1*2+4-25/5");
        System.out.println(calculate);
    }

    public int calculate(String s) {
        int ans = 0;
        int n = s.length();
        int currentNumber = 0;
        Stack<Integer> stack = new Stack<>();
        char operation = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber = (currentNumber * 10) + (c - '0');
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == n - 1) {
                if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                }
                operation = c;
                currentNumber = 0;
            }
        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}