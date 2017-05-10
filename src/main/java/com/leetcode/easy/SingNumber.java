package com.leetcode.easy;

public class SingNumber {
	public static void main(String[] args) {
		int a[]={2,2,1,1,5};
		System.out.println(singleNumber(a));
	}
	public static int singleNumber(int[] nums) {
		int result=0;
		for(int i=0;i<nums.length;++i)
			result^=nums[i];
		return result;
    }
}
