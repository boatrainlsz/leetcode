package com.boatrain.array;

/**
 * https://leetcode-cn.com/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {
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
                int temp = pile / mid;
                int mod = pile % mid;
                if (mod != 0) {
                    temp++;
                }
                sum += temp;
            }
            if (sum > H) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}