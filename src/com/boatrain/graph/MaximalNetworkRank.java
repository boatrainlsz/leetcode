package com.boatrain.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/maximal-network-rank/
 */
public class MaximalNetworkRank {
    public static void main(String[] args) {
        MaximalNetworkRank solution = new MaximalNetworkRank();
        int[][] roads = {{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}};
        int n = 5;
        System.out.println(solution.maximalNetworkRank(n, roads));
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
            adj.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> neighbors1 = adj.getOrDefault(i, new HashSet<>());
            for (int j = i + 1; j < n; j++) {
                Set<Integer> neighbors2 = adj.getOrDefault(j, new HashSet<>());
                int temp = neighbors2.size() + neighbors1.size();
                if (neighbors2.contains(i) && neighbors1.contains(j)) {
                    temp--;
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}