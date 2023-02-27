package com.boatrain.array;

public class DecreaseElementsToMakeArrayZigzag {
    public static void main(String[] args) {
        DecreaseElementsToMakeArrayZigzag solution = new DecreaseElementsToMakeArrayZigzag();
        System.out.println(solution.movesToMakeZigzag(new int[]{2, 7, 10, 9, 8, 9}));
    }

    public int movesToMakeZigzag(int[] nums) {
        int ans1 = 0;
        int ans2 = 0;
        int[] nums1 = new int[nums.length];
        System.arraycopy(nums, 0, nums1, 0, nums1.length);
        for (int i = 0; i < nums1.length - 1; i++) {
            if (i % 2 == 0 && nums1[i] <= nums1[i + 1]) {
                ans1 += (nums1[i + 1] - nums1[i] + 1);
                nums1[i + 1] = nums1[i] - 1;
            }
            if (i % 2 == 1 && nums1[i] >= nums1[i + 1]) {
                ans1 += (nums1[i] - nums1[i + 1] + 1);
                nums1[i] = nums1[i + 1] - 1;
            }
        }
        System.arraycopy(nums, 0, nums1, 0, nums1.length);
        for (int i = 0; i < nums1.length - 1; i++) {
            if (i % 2 == 0 && nums1[i] >= nums1[i + 1]) {
                ans2 += (nums1[i] - nums1[i + 1] + 1);
                nums1[i] = nums1[i + 1] - 1;
            }
            if (i % 2 == 1 && nums1[i] <= nums1[i + 1]) {
                ans2 += (nums1[i + 1] - nums1[i] + 1);
                nums1[i + 1] = nums1[i] - 1;
            }
        }
        return Math.min(ans2, ans1);
    }
}