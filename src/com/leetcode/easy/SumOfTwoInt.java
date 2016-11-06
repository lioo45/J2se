package com.leetcode.easy;

public class SumOfTwoInt {
	public static void main(String[] args) {
		System.out.println(getSum(45,1));
	}
	public static int getSum(int a,int b){
		int t;
		while((t=a&b)!=0){
			t=t<<1;
			int t1=a^b;
			a=t;b=t1;
		}
		return a|b;
	}
}
