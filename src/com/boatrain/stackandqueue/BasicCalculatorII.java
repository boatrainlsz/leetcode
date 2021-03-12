package com.boatrain.stackandqueue;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        int calculate = basicCalculatorII.calculateWithoutStack("1*2+4-25/5");
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

    public int calculateWithoutStack(String s) {
        int ans = 0;
        int n = s.length();
        int currentNumber = 0, lastNumber = 0;
        char operation = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber = (currentNumber * 10) + (c - '0');
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == n - 1) {
                if (operation == '*') {
                    lastNumber *= currentNumber;
                } else if (operation == '/') {
                    lastNumber /= currentNumber;
                } else if (operation == '+' || operation == '-') {
                    ans += lastNumber;
                    lastNumber = operation == '+' ? currentNumber : -currentNumber;
                }
                operation = c;
                currentNumber = 0;
            }
        }
        ans += lastNumber;
        return ans;
    }
}