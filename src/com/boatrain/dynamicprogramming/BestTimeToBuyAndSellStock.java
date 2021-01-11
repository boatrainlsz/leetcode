package com.boatrain.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
//        int[] array = {7,6,4,3,1};
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        System.out.println(solution.maxProfit(array));
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
