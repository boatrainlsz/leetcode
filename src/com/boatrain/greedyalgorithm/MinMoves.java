package com.boatrain.greedyalgorithm;

/**
 * https://leetcode-cn.com/problems/minimum-moves-to-reach-target-score
 */
public class MinMoves {
    public int minMoves(int target, int maxDoubles) {
        if (target == 1) return 0;
        //加倍次数用完，只能递增
        if (maxDoubles == 0) return target - 1;
        //target / 2变到 target要消耗一次double，如果target为奇数，则还需要消耗一次递增
        return target % 2 + 1 + minMoves(target / 2, maxDoubles - 1);
    }

}
