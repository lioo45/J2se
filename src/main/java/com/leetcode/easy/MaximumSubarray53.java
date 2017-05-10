package com.leetcode.easy;

import java.lang.management.BufferPoolMXBean;

/**
 * Created by pro on 17/3/8.
 * O(n)
 */
public class MaximumSubarray53 {

    public static void main(String[] args) {
        int a[]={-2,1,-3,4,-1,2,1,-5,4};
        int b[]={0,2,0,2};
        System.out.println(maxSubArray(a));
        System.out.println(maxSubArray(b));
    }

    public  static  int maxSubArray(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int max=nums[0];
        int buffer=max;
        for (int i = 0; i <nums.length-1 ; i++) {
            if(max>0){
                if(buffer<0)
                    buffer=0;
                buffer+=nums[i+1];
                max=buffer>max?buffer:max;
            }
            else{
                if(nums[i+1]>0)
                    max=buffer=nums[i+1];
                else
                    max=max>nums[i+1]?max:nums[i+1];
            }
        }
        return max;
    }

}
