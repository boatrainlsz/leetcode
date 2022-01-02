package com.boatrain;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/elimination-game/
 */
public class EliminationGame1 {
    public static void main(String[] args) {
        EliminationGame1 solution = new EliminationGame1();
        System.out.println(solution.lastRemaining(1));
    }

    public int lastRemaining(int n) {
        if (n == 1 || n == 2) return n;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Integer head = list.get(0);
        return list.get(0);
    }
}
