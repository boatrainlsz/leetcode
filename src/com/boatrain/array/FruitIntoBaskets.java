package com.boatrain.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ServiceConfigurationError;

/**
 * <a href="https://leetcode.cn/problems/fruit-into-baskets/">...</a>
 */
public class FruitIntoBaskets {
    public static void main(String[] args) {
        FruitIntoBaskets solution = new FruitIntoBaskets();
//        System.out.println(solution.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        System.out.println(solution.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
//        System.out.println(solution.totalFruit(new int[]{0, 1, 2, 2}));
//        System.out.println(solution.totalFruit(new int[]{1, 2, 3, 2, 2}));
    }

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

