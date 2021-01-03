package com.boatrain.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/count-good-meals/submissions/
 */
public class CountGoodMeals {
    public static void main(String[] args) {
        CountGoodMeals solution = new CountGoodMeals();
        int[] deliciousness = new int[]{2, 14, 11, 5, 1744, 2352, 0, 1, 1300, 2796, 0, 4, 376, 1672,
                73, 55, 2006, 42, 10, 6, 0, 2, 2, 0, 0, 1, 0, 1, 0, 2, 271, 241, 1,
                63, 1117, 931, 3, 5, 378, 646, 2, 0, 2, 0, 15, 1};
        System.out.println("答案：" + solution.countPairs(deliciousness));
    }

    public int countPairs(int[] d) {
        double mod = 1e9 + 7;
        Map<Integer, Integer> countMap = new HashMap<>();
        int count = 0;
        for (int num : d) {
            for (int i = 0; i <= 21; i++) {
                int target = (1 << i) - num;
                if (countMap.containsKey(target)) {
                    count = (int) ((count + countMap.get(target)) % mod);
                }
            }
            countMap.merge(num, 1, Integer::sum);
        }
        return (int) (count % mod);
    }
}