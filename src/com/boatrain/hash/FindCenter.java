package com.boatrain.hash;

import java.util.Comparator;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/find-center-of-star-graph/
 */
class FindCenter {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int[] edge : edges) {
            countMap.merge(edge[0], 1, Integer::sum);
            countMap.merge(edge[1], 1, Integer::sum);
        }
        return countMap.keySet().stream().max(Comparator.comparingInt(countMap::get)).get();
    }
}