package com.boatrain.array;

/**
 * https://leetcode-cn.com/problems/wiggle-subsequence/
 */
public class WiggleSubsequence {
    public static void main(String[] args) {
        WiggleSubsequence solution = new WiggleSubsequence();
        System.out.println(solution.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    }

    public int wiggleMaxLength(int[] nums) {
        int length=nums.length;
        int count=0;
        int last=0;
        for (int i=1;i<length;i++){
            last+=nums[i]-nums[i-1];
            if(last!=0){
                break;
            }
        }
        int cur=0;
        for (int i=2;i<length;i++){
            cur+=nums[i]-nums[i-1];
            if(last*cur<0){
                count++;
                last=cur;
                cur=0;
            }
        }


    return count+1;
    }
}