package com.boatrain.hash;

/**
 * https://leetcode-cn.com/problems/find-center-of-star-graph/
 */
class FindCenter {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] degree = new int[n + 1];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}