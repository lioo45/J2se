package com.leetcode.easy;

public class AddDigits {
	public static void main(String[] args) {
		System.out.println(addDigits(10));
	}
	public static int addDigits(int num) {
		int sum=0;
		while(num!=0){
			sum+=num%10;
			num/=10;
		}
		num=0;
		num+=sum%10;
		sum/=10;
		num+=sum%10;
//		if(num/10!=0){
			sum=0;
			sum+=num%10;
			num/=10;
			sum+=num%10;
			return sum;
//		}
//		return num;
    }
}
