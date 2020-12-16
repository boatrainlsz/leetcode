package com.boatrain.numbers;

import java.util.HashMap;

class WordPattern {
    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog dog dog dog"));
    }


    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        String[] split = s.split(" ");
        int length = pattern.length();
        if (pattern.length() != split.length) return false;
        for (int i = 0; i < length; i++) {
            String str = split[i];
            char c = pattern.charAt(i);
            if (map1.get(c) == null) {
                map1.put(c, str);
            } else {
                if (!map1.get(c).equals(str)) {
                    return false;
                }
            }
            if (map2.get(str) == null) {
                map2.put(str, c);
            } else {
                if (!map2.get(str).equals(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}