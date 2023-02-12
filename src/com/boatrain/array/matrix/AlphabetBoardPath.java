package com.boatrain.array.matrix;

import java.util.Map;

/*
https://leetcode.cn/problems/alphabet-board-path/
* */
public class AlphabetBoardPath {
    public static void main(String[] args) {
        AlphabetBoardPath solution = new AlphabetBoardPath();
        System.out.println(solution.alphabetBoardPath("xz"));
    }

    public String alphabetBoardPath(String target) {
        char[] targetArr = target.toCharArray();
        StringBuilder ans = new StringBuilder();
        int[] curPos = new int[]{0, 0};
        for (char c : targetArr) {
            int x = (c - 'a') % 5;
            int y = (c - 'a') / 5;
            int xOffset = x - curPos[0];
            int yOffset = y - curPos[1];
            if (xOffset == 0 && yOffset == 0) {
                ans.append("!");
                continue;
            }
            if (c == 'z') {
                //去字母z，必须先偏移x方向，再y方向
                offsetX(ans, xOffset);
                offsetY(ans, yOffset);
            } else {
                offsetY(ans, yOffset);
                offsetX(ans, xOffset);
            }
            ans.append("!");
            curPos[0] = x;
            curPos[1] = y;
        }
        return ans.toString();
    }

    private static void offsetY(StringBuilder ans, int yOffset) {
        for (int i = 0; i < Math.abs(yOffset); i++) {
            if (yOffset > 0) {
                ans.append("D");
            } else if (yOffset < 0) {
                ans.append("U");
            }
        }
    }

    private static void offsetX(StringBuilder ans, int xOffset) {
        for (int i = 0; i < Math.abs(xOffset); i++) {
            if (xOffset > 0) {
                ans.append("R");
            } else if (xOffset < 0) {
                ans.append("L");
            }
        }
    }
}