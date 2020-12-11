package com.boatrain.dynamicprogramming;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
//todo wrong answer
public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
//        int[] array = {2, 6, 8, 7, 8, 7, 9, 4, 1, 2, 4, 5, 8};
//        int[] array = {1,3,5,4,3,7,6,9,2,4};
        int[] array = {1,3,5,4,3,7,6,9,2,4};
//        int[] array = {1,2,3,0,2};
//        int[] array = {7,6,4,3,1};
        BestTimeToBuyAndSellStockWithCooldown solution = new BestTimeToBuyAndSellStockWithCooldown();
        System.out.println(solution.maxProfit(array));
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i <= prices.length - 1; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        for (int i = 3; i < prices.length; i++) {
            if (prices[i - 3] < prices[i - 2] &&
                    prices[i - 1] < prices[i] &&
                    prices[i - 2] > prices[i - 1]) {
                int min = Math.min(Math.min(prices[i - 2] - prices[i - 3], prices[i] - prices[i - 1])
                        , prices[i - 2] - prices[i - 1]);
                ans -= min;
            }
        }

        for (int j = 5; j < prices.length; j++) {
            if (prices[j - 3] < prices[j - 2] &&
                    prices[j - 1] < prices[j] &&
                    prices[j - 2] > prices[j - 1] &&
                    prices[j - 5] < prices[j - 4] &&
                    prices[j - 4] > prices[j - 3] &&
                    prices[j - 4] - prices[j - 5] +prices[j] - prices[j - 1]> prices[j - 2] - prices[j - 3]) {
                int a = prices[j - 4] - prices[j - 5];
                int b = prices[j - 2] - prices[j - 3];
                int c = prices[j ] - prices[j - 1];
                int d = prices[j - 3] - prices[j - 4];
                int e = prices[j - 1] - prices[j - 2];
                if (b<a&&b<c&&b<d&&b<e){
                    ans+=b;
                }else if ((a>b && b>c)|| (c>b && b>a)){
                    ans+=Math.min(a,d)+Math.min(c,e)-b;
                }else if (a<b&& c<b){
                    ans+=a+c-b;
                }
            }
        }

        return ans;
    }
}
