package com.leetcode.easy;

public class FindTheDifference {
	public static void main(String[] args) {
		String s="qwertyuiop";
		String t="iopyuergtwq";
		System.out.println(findTheDifference(s,t));
	}

	 public static char findTheDifference(String s, String t) {
		 char c=0;
		 for(int i=0;i<s.length();++i)
			 c^=s.charAt(i)^t.charAt(i);
		 return (char) (c^t.charAt(t.length()-1));
	 }
}
