package com.boatrain.slidingwindow;

/**
 * https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 */
public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        GrumpyBookstoreOwner solution = new GrumpyBookstoreOwner();
        int[] customers = new int[]{4, 10, 10};
        int[] grumpy = new int[]{1, 1, 0};
        int X = 2;
        System.out.println(solution.maxSatisfied(customers, grumpy, X));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        //全都满意的客人数量前缀和
        int[] best = new int[n];
        //满意的客人数量前缀和
        int[] good = new int[n];
        best[0] = customers[0];
        good[0] = customers[0] * (1 - grumpy[0]);
        for (int i = 1; i < n; i++) {
            best[i] = customers[i] + best[i - 1];
            good[i] = customers[i] * (1 - grumpy[i]) + good[i - 1];
        }
        int res = best[X - 1] + good[n - 1] - good[X - 1];
        for (int i = X; i < n; i++) {
            int temp = best[i] - best[i - X] + good[i - X] + good[n - 1] - good[i];
            res = Math.max(res, temp);
        }
        return res;
    }
}