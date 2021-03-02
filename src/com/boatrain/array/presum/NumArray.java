package com.boatrain.array.presum;

class NumArray {
    private int[] nums;
    private int size;
    private int[] preSum;

   public NumArray(int[] nums) {
        size=nums.length;
        if(size==0){
            return ;
        }
        this.nums=nums;
        preSum=new int[size];
        preSum[0]=nums[0];
        for(int i=1;i<size;i++){
            preSum[i]=preSum[i-1]+nums[i];
        }
    }
    public int sumRange(int i, int j) {
        return preSum[j]-preSum[i]+nums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */