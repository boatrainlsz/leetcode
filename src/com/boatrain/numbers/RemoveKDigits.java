package com.boatrain.numbers;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/remove-k-digits/
 * todo 未完成
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        RemoveKDigits solution = new RemoveKDigits();
        String s = "ss";
        char c = s.charAt(1);
        System.out.println(solution.removeKdigits("1432219",3));
    }

    public String removeKdigits(String num, int k) {
        PriorityQueue<Character> queue = new PriorityQueue<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (queue.size() == k) {
                if (queue.peek() < c) {
                    queue.poll();
                    queue.add(c);
                }
            } else {
                queue.add(c);
            }
        }
        String result = "";
        for (int i = 0; i < num.length(); i++) {
            if (!queue.contains(num.charAt(i))) {
                result += num.charAt(i);
            }
        }
        return result;
    }
}
