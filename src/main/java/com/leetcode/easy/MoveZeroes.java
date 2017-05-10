package com.leetcode.easy;

public class MoveZeroes {
	public static void main(String[] args) {
		int a[]={0};
		moveZeroes(a);
		for(int i:a)
		System.out.println(i);
	}
	public static  void moveZeroes(int[] nums) {
		int j=0;
        for(int i=0;i<nums.length;++i){
        	if(nums[i]!=0){
        		nums[j]=nums[i];
        		++j;
        	}
        }
        while(j<nums.length){
        	nums[j]=0;
        	++j;
        }
        
    }
}
