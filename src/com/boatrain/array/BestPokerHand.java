package com.boatrain.array;

import java.util.HashMap;
import java.util.Map;

/*
*https://leetcode.cn/problems/best-poker-hand/
*  */
public class BestPokerHand {
    public String bestHand(int[] ranks, char[] suits) {
        Map<Integer, Integer> count = new HashMap<>();
        char suit = suits[0];
        boolean isFlush = true;
        for (int i = 0; i < ranks.length; i++) {
            if (isFlush && suits[i] != suit) {
                isFlush = false;
            }
            count.merge(ranks[i], 1, Integer::sum);
            if (!isFlush && count.get(ranks[i]) >= 3) {
                return "Three of a Kind";
            }
        }
        for (Integer freq : count.values()) {
            if (freq == 2) {
                return "Pair";
            }
        }
        if (isFlush) return "Flush";
        return "High Card";
    }
}