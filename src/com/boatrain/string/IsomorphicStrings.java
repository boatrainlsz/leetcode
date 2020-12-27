package com.boatrain.string;

import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings solution = new IsomorphicStrings();
        System.out.println(solution.isIsomorphic("paper","title"));
    }

    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        int length = s.length();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < length; i++) {
            char c1 = t.charAt(i);
            char c = s.charAt(i);
            if (map1.get(c) == null) {
                map1.put(c, c1);
            } else {
                if (!map1.get(c).equals(c1)) {
                    return false;
                }
            }
            if (map2.get(c1) == null) {
                map2.put(c1, c);
            } else {
                if (!map2.get(c1).equals(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
