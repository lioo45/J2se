package com.leetcode.easy;

/**
 * Created by pro on 16/11/14.
 */
public class NumArray {

        int[] nums;
    public static void main(String[] args) {
        int a[]={-2,0,3,-5,2,-1};
        NumArray na=new NumArray(a);
        System.out.println(na.sumRange(0,2));
        System.out.println(na.sumRange(2,5));
        System.out.println(na.sumRange(0,5));
    }
        public NumArray(int[] nums) {
            this.nums=nums;
        }

        public int sumRange(int i, int j) {
            if(j<i){
                int t=i;
                i=j;
                j=t;
            }

            int sum=0;
            for(int k=i;k<=j&&k<nums.length;++k)
                sum+=nums[k];

            return sum;
        }


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
}
