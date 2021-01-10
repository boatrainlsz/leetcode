package com.boatrain.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII solution = new BestTimeToBuyAndSellStockIII();
//        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int n = prices.length;
        //former[i]:[0,i]天内买卖一次能获取的最大利润
        int[] former = new int[n];
        //latter[i]:[i,n-1]天内买卖一次能获取的最大利润
        int[] latter = new int[n];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
            former[i] = maxProfit;
        }
        int ans = former[n - 1];
        int maxPrice = 0;
        maxProfit = 0;
        for (int i = n - 1; i > 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            } else if (maxPrice - prices[i] > maxProfit) {
                maxProfit = maxPrice - prices[i];
            }
            ans = Math.max(ans, former[i - 1] + maxProfit);
        }
        return ans;
    }
}
