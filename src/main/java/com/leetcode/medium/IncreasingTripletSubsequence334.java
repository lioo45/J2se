package com.leetcode.medium;

/**
 * Created by pro on 16/11/20.
 */
public class IncreasingTripletSubsequence334 {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        int b[]={5,4,3,2,1};
        int c[]={5,1,4,6,3};
        System.out.println(increasingTriplet2(a));
        System.out.println(increasingTriplet2(b));
        System.out.println(increasingTriplet2(c));
    }
    //暴力 时间O(n^2)不太好
    public static boolean increasingTriplet(int[] nums) {
        if(nums.length<3)
            return false;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[j]>nums[i]){
                    for(int k=j+1;k<nums.length;++k){
                        if(nums[k]>nums[j])
                            return true;
                    }
                }
            }
        }
        return false;
    }
    //时间O(n)
    public static boolean increasingTriplet2(int nums[]){
        if(nums.length<3)
            return false;
        int left=nums[0];
        int right=0;
        int k=0;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]>left){
                right=nums[i];
                k=i+1;
                break;
            }
            else
                left=nums[i];
        }
        if(k==0)
            return false;
        for (int i = k; i <nums.length ; i++) {
            if(nums[i]>right)
                return true;
            else if(nums[i]>left)
                right=nums[i];
            else
                left=nums[i];

        }
        return false;
    }
}
