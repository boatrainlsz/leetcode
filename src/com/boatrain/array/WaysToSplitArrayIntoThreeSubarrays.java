package com.boatrain.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/ways-to-split-array-into-three-subarrays/
 * 区间和，双指针
 */
public class WaysToSplitArrayIntoThreeSubarrays {
    public static void main(String[] args) {
        WaysToSplitArrayIntoThreeSubarrays solution = new WaysToSplitArrayIntoThreeSubarrays();
        int[] nums = new int[]{1, 2, 2, 2, 5, 0};
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(sums));
        System.out.println(solution.waysToSplit(nums));
    }

    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int res = 0;
        //min是中区间左端点能取的最小值，max是中区间右端点能取到的最大值+1
        int low = 0, upper = 0;
        for (int i = 0; i < n - 2; ++i) {
            low = Math.max(i + 1, low);
            while (low < n - 1 && sum[low] - sum[i] < sum[i]) {
                low++;
            }
            if (low == n - 1) {
                break;
            }
            upper = Math.max(upper, low);
            while (upper < n - 1 && sum[n - 1] - sum[upper] >= sum[upper] - sum[i]) {
                upper++;
            }
            res = (res + (upper - low)) % 1000000007;
        }
        return res;
    }
}
