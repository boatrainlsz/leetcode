package com.boatrain;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/tuple-with-same-product/comments/
 */
public class TupleWithSameProduct {
    public static void main(String[] args) {
        TupleWithSameProduct solution = new TupleWithSameProduct();
//        int[] nums = {2, 3, 4, 6};
//        int[] nums = {1,2,4,5,10};
        int[] nums = {2, 3, 4, 6, 8, 12};
        System.out.println(solution.tupleSameProduct(nums));
    }

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cntMap.merge(nums[i] * nums[j], 1, Integer::sum);
            }
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            Integer k = entry.getValue();
            if (k >= 2) {
                //k对里面取2对，排列组合公式
                //2对取出来后，又有8种组合方式。
                cnt += ((k * k - k) / 2) * 8;
            }
        }
        return cnt;
    }
}