package com.boatrain.array.presum;

/**
 * https://leetcode-cn.com/problems/continuous-subarray-sum/solution/qian-zhui-he-yu-intmapde-zai-ci-ying-yong-by-chris/
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (k == 0) {
                    if ((pre[j] - pre[i] + nums[i]) == 0)
                        return true;
                } else if ((pre[j] - pre[i] + nums[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
