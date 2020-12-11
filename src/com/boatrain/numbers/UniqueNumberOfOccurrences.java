package com.boatrain.numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */
public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        UniqueNumberOfOccurrences solution = new UniqueNumberOfOccurrences();
        System.out.println(solution.uniqueOccurrences(new int[]{1,2,3,4,5,5}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countMap.merge(arr[i], 1, Integer::sum);
        }
        //检查countMap有没有相同的value
        ArrayList<Integer> list = new ArrayList<>(countMap.values());
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) return false;
            }
        }
        return true;
    }
}
