package com.boatrain.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
//        int[] array = {7, 1, 5, 3, 6, 4};
        int[] array = {1,2,3,4,5};
//        int[] array = {7,6,4,3,1};
        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();
        System.out.println(solution.maxProfit(array));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int curStocks = -1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                curStocks = prices[i - 1];
            } else if (curStocks != -1) {
                maxProfit += prices[i - 1] - curStocks;
                curStocks = -1;
            }
        }
        return maxProfit;
    }
}
