package com.boatrain.string;

/**
 * https://leetcode.cn/problems/one-away-lcci
 */
public class OneAwayLcci {
    public boolean oneEditAway(String first, String second) {
        if (first.equals(second)) {
            return true;
        }
        int m = first.length();
        int n = second.length();
        //m=n，检查replace
        if (m == n) {
            return checkReplace(first, second, m);
        }
        //m=n+1||m=n-1,检查insert
        if (m == n + 1) {
            return checkInsert(first, second, m, n);
        }
        if (m == n - 1) {
            return checkInsert(second, first, n, m);
        }
        return false;
    }

    private boolean checkInsert(String longer, String shorter, int lLen, int sLen) {
        int i = 0, j = 0;
        while (i < lLen && j < sLen) {
            if (longer.charAt(i) == shorter.charAt(j)) {
                j++;
            }
            i++;
            if (i - j > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean checkReplace(String first, String second, int m) {
        boolean diffFound = false;
        for (int i = 0; i < m; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (!diffFound) {
                    diffFound = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}