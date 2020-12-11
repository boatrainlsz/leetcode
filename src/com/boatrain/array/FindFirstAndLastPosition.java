package com.boatrain.array;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPosition {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstIndex = findFirstIndex(nums, target);
        if (firstIndex == -1) {
            return new int[]{-1, -1};
        }
        int lastIndex = findLastIndex(nums, target);
        return new int[]{firstIndex, lastIndex};
    }

    private int findLastIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        //退出循环的条件是left = right
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) {
                //最后一个target不可能在[left,mid],下一个搜索区间为[mid+1,right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                //最后target不可能在[left,mid-1],下一个搜索区间为[mid,right]
                left = mid;
            } else if (nums[mid] > target) {
                //最后target不可能在[mid,right],下一个搜索区间为[left,mid-1]
                right = mid - 1;
            }
        }
        //到这里，left=right
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        //退出循环的条件是left = right
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                //第一个target不可能在[left,mid],下一个搜索区间为[mid+1,right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                //第一个target不可能在[mid+1,right],下一个搜索区间为[left,mid]
                right = mid;
            } else if (nums[mid] > target) {
                //第一个target不可能在[mid,right],下一个搜索区间为[left,mid-1]
                right = mid - 1;
            }
        }
        //到这里，left=right
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
