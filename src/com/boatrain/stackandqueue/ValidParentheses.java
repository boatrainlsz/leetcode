package com.boatrain.stackandqueue;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.empty()) return false;
                char peek = stack.peek();
                if (match(peek, c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean match(char peek, char c) {
        return (c == '}' && peek == '{') || (c == ')' && peek == '(') || (c == ']' && peek == '[');
    }
}