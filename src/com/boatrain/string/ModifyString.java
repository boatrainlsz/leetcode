package com.boatrain.string;

public class ModifyString {
    public String modifyString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ch++) {
                    if ((i > 0 && chars[i - 1] == ch) || (i < n - 1 && chars[i + 1] == ch)) {
                        continue;
                    }
                    chars[i] = ch;
                    break;
                }
            }
        }
        return new String(chars);
    }
}