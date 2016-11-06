package com.leetcode.easy;

public class ReverseString {
	public static void main(String[] args) {
		String s="Margelet's \"went.\" I await news telegram.";
		System.out.println(s);
		System.out.println(reverseString(s));
	}
	public static String reverseString(String s) {
        char c[]=s.toCharArray();
        int left=0;
        int right=c.length-1;
        char t;
        while(left<right){
        	if(c[left]=='\\'&&c[left+1]!='\\'){
        		left++;
        		continue;
        	}
        	if(c[right]=='\\'&&c[right-1]!='\\'){
        		right--;
        		continue;
        	}
        	t=c[left];
        	c[left]=c[right]; 
        	c[right]=t;
        	left++;
        	right--;
        }
        return new String(c);
       
    }
}
