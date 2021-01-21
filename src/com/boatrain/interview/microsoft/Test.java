package com.boatrain.interview.microsoft;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("()()()()", "(()())()", "(()(()))", "()()(())", "(())()()", "(((())))", "()((()))", "()(())()", "()(()())", "(()()())", "((()()))", "((()))()", "((())())");
        List<String> list1 = Arrays.asList("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()");
        for (String s : list1) {
            if (!list.contains(s)){
                System.out.println(s);
            }
        }
    }
}
