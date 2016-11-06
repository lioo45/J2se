package com.leetcode.easy;

public class NigName {
	public static void main(String[] args) {
		System.out.println(canWinNim(300));
	}
	
	public static boolean canWinNim(int n) {
		return n%4==0?false:true;
	}
	//第一次错在没有判断<=3
	//第二次错在空间复杂度
	//第三次错在时间复杂度
//	if(n<=3)
//		return true;
//	boolean r1,r2,r3,r4=false;;
//	r1=r2=r3=true;
//	for(int i=4;i<n+1;++i){
//		r4=!r1||!r2||!r3;
//		r1=r2;r2=r3;r3=r4;
//	}
//	return r4;
	
}
