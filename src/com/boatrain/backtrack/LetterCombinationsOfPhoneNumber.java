package com.boatrain.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    private static final String[] letterMap = new String[]{" ", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == "") {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {

        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        return;
    }
}