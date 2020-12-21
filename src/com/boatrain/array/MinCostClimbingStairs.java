package com.boatrain.array;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs solution = new MinCostClimbingStairs();
        System.out.println(solution.minCostClimbingStairs(new int[]{0, 1, 2, 2}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int[] minCost = new int[size];
        minCost[0] = cost[0];
        minCost[1] = Math.min(0, minCost[0])+cost[1];
        for (int i = 2; i < size; i++) {
            minCost[i] = Math.min(minCost[i - 2],minCost[i - 1])+cost[i];
        }
        return Math.min(minCost[size - 2],minCost[size - 1]);
    }
}
