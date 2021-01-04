package com.boatrain.array;

/**
 * https://leetcode-cn.com/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        KokoEatingBananas solution = new KokoEatingBananas();
        int[] piles = new int[]{30, 11, 23, 4, 20};
        System.out.println(solution.minEatingSpeed(piles, 8));
    }

    public int minEatingSpeed(int[] piles, int H) {
        int l = 1;
        int r = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            r = Math.max(r, piles[i]);
        }
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int sum = 0;
            for (int pile : piles) {
                //将quotient向上取整
                int quotient = pile / mid;
                int remainder = pile % mid;
                if (remainder != 0) {
                    quotient++;
                }
                sum += quotient;
            }
            if (sum > H) {
                //用mid速度吃，还是太慢了
                l = mid + 1;
            } else {
                //用mid速度可以满足，尝试能不能找到更小的速度
                r = mid - 1;
            }
        }
        return l;
    }
}