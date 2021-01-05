package com.boatrain.array.hash;

import java.util.HashSet;

public class UniqueMorseRepresentations {
    String[] map = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public static void main(String[] args) {
        UniqueMorseRepresentations solution = new UniqueMorseRepresentations();
        System.out.println(solution.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder translation = new StringBuilder();
            char[] chars = word.toCharArray();
            for (char cha : chars) {
                translation.append(map[cha - 'a']);
            }
            set.add(translation.toString());
        }
        return set.size();
    }
}
