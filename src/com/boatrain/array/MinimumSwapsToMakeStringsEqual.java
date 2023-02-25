package com.boatrain.array;

public class MinimumSwapsToMakeStringsEqual {
    public int minimumSwap(String s1, String s2) {
        int[] diff = new int[s1.length()];
        int positiveCnt = 0;
        int negativeCnt = 0;
        for (int i = 0; i < diff.length; i++) {
            diff[i] = s1.charAt(i) - s2.charAt(i);
            if (diff[i] > 0) {
                positiveCnt++;
            } else if (diff[i] < 0) {
                negativeCnt++;
            }
        }
        if ((positiveCnt + negativeCnt) % 2 != 0) {
            return -1;
        }
        return positiveCnt / 2 + negativeCnt / 2 + positiveCnt % 2 + negativeCnt % 2;
    }
}