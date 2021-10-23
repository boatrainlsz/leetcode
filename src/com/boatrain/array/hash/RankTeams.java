package com.boatrain.array.hash;

import java.util.Arrays;
import java.util.HashMap;

class RankTeams {
    public String rankTeams(String[] votes) {
        HashMap<Character, int[]> map = new HashMap<>();
        for (String vote : votes) {
            char[] arr = vote.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char letter = arr[i];
                map.computeIfAbsent(letter, character -> {
                    return new int[26];
                });
                int[] rank = map.computeIfAbsent(letter, k -> new int[26]);
                rank[i]++;
            }
        }
        char[] array = votes[0].toCharArray();
        Character[] ansArr = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            ansArr[i] = array[i];
        }
        for (int[] value : map.values()) {
            System.out.println(Arrays.toString(value));
        }
        System.out.println(map.keySet());
        Arrays.sort(ansArr, (c1, c2) -> {
            int[] rank1 = map.get(c1);
            int[] rank2 = map.get(c2);
            for (int i = 0; i < 26; i++) {
                if (rank1[i] != rank2[i]) {
                    return rank2[i] - rank1[i];
                }
            }
            return c1 - c2;
        });
        StringBuilder ans = new StringBuilder();
        for (Character character : ansArr) {
            ans.append(character);
        }
        return ans.toString();
    }
}