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
            if (map1.get(pattern.charAt(i)) == null) {
                map1.put(pattern.charAt(i), split[i]);
            } else {
                if (!map1.get(pattern.charAt(i)).equals(split[i])) {
                    return false;
                }
            }
            if (map2.get(split[i]) == null) {
                map2.put(split[i], pattern.charAt(i));
            } else {
                if (!map2.get(split[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}