package com.boatrain.hash;

/**
 * https://leetcode-cn.com/problems/find-center-of-star-graph/
 */
class FindCenter {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] count = new int[n + 1];
        for (int[] edge : edges) {
            count[edge[0]]++;
            count[edge[1]]++;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
                index = i;
            }
        }
        return index;
    }
}