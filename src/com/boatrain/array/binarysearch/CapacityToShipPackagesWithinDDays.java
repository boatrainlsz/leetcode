package com.boatrain.array.binarysearch;

/**
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays solution = new CapacityToShipPackagesWithinDDays();
        int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 5;
        System.out.println(solution.shipWithinDays(weights, D));
    }

    public int shipWithinDays(int[] weights, int D) {
        int lo = 0;
        int hi = 0;
        int n = weights.length;
        /**
         * 对K进行二分枚举
         * 枚举的最小值是max(weight[i])，因为如果比max(weight[i])还小，那max(weight[i])这个包裹永远无法运送
         * 枚举的最大值是sum(weight[i])，最大值可以是Integer.MAX_VALUE，但是没必要，因为如果K=sum(weight[i]),直接一天运完拉倒。
         */
        for (int i = 0; i < n; i++) {
            lo = Math.max(lo, weights[i]);
            hi += weights[i];
        }
        while (lo < hi) {
            int K = lo + ((hi - lo) >> 1);

            int curWeight = 0;
            //计算船运载能力为K时，需要花费的天数。
            int days = 1;
            for (int i = 0; i < n; i++) {
                curWeight += weights[i];
                if (curWeight > K) {
                    //加上weights[i]就超重了，那weights[i]就放到第二天运送，所以days++
                    curWeight = weights[i];
                    days++;
                    if (days > D) {
                        //需要花费的天数超过D了，说明K小了。在[K+1,hi]中继续寻找
                        lo = K + 1;
                        break;
                    }
                }
            }
            //需要花费的天数不超过D，尝试寻找更小的K，在[lo,K]中继续寻找
            if (days <= D) {
                hi = K;
            }
        }
        return lo;
    }

}
