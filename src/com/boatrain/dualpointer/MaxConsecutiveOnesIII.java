package com.boatrain.dualpointer;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int ans = 0;
        int left = 0, right = 0, leftSum = 0, rightSum = 0;
        while (right < n) {
            rightSum += 1 - A[right];
            while (leftSum < rightSum - K) {
                leftSum += 1 - A[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}