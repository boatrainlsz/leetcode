package com.boatrain.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class RepeatedDnaSequences {
    public static void main(String[] args) {
        RepeatedDnaSequences solution = new RepeatedDnaSequences();
        System.out.println(solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    Map<String, Integer> countMap = new HashMap<>();

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> ans = new HashSet<>();
        int len = s.length();
        if (len < 10) return Collections.emptyList();
        for (int i = 0; i < len - 9; i++) {
            String candidate = s.substring(i, i + 10);
            countMap.merge(candidate, 1, Integer::sum);
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }
        return new ArrayList<>(ans);
    }
}