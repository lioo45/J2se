package com.leetcode.easy;

public class ESCT168 {
	public static void main(String[] args) {
		System.out.println(convertToTitle(54));
	}
	public  static String convertToTitle(int n) {
        StringBuffer sb=new StringBuffer();
		char c='A'-1;
		char b;
		while(n!=0){
        	int flag=0;
			if(n%26!=0)
        		b=(char) (c+n%26);
        	else {
				b = 'Z';
				flag=1;
			}
        	sb.append(b);
        	n=n/26;
			n-=flag;
        }
        return sb.reverse().toString();
    }
}
