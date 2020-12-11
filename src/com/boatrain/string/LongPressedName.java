package com.boatrain.string;

/**
 * https://leetcode-cn.com/problems/long-pressed-name
 */
public class LongPressedName {
    public static void main(String[] args) {
        LongPressedName solution = new LongPressedName();
        //alex aaleex
        //abc,ccab
        System.out.println(solution.isLongPressedName("vtkgn", "vttkgnn"));
    }

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
