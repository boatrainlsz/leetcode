package com.boatrain.string;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/backspace-string-compare/
 * 给定 S 和 T 两个字符串，
 * 当它们分别被输入到空白的文本编辑器后，
 * 判断二者是否相等，并返回结果。 # 代表退格字符。
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        BackspaceStringCompare solution = new BackspaceStringCompare();
        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
    }

    public boolean backspaceCompare(String S, String T) {
        //用栈
        Stack<Character> sStack = getStack(S);
        Stack<Character> tStack = getStack(T);
        if (sStack.size() != tStack.size()) return false;
        while (!sStack.isEmpty()) {
            if (!sStack.pop().equals(tStack.pop())) {
                return false;
            }
        }
        return true;
    }

    private Stack<Character> getStack(String s) {
        Stack<Character> sStack = new Stack<>();
        int index = 0;
        while (index != s.length()) {
            if (s.charAt(index) != '#') {
                sStack.push(s.charAt(index));
            } else if (!sStack.isEmpty()){
                sStack.pop();
            }
            index++;
        }
        return sStack;
    }
}
