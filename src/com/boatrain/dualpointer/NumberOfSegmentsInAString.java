package com.boatrain.dualpointer;

/**
 * <a href="https://leetcode.cn/problems/number-of-segments-in-a-string/submissions/">...</a>
 * */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && s.charAt(j) != ' ') j++;
            if (i != j) ans++;
            i = j;
        }
        return ans;
    }
}