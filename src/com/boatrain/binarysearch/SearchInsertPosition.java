package com.boatrain.binarysearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (target > nums[r]) return r + 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}