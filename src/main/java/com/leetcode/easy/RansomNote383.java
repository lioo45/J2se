package com.leetcode.easy;

public class RansomNote383 {
		public static void main(String[] args) { 
			System.out.println(canConstruct("aa","aab"));
		}
		public static boolean canConstruct(String ransomNote, String magazine) {
	        int hash[]=new int[256];
	        for(char c:magazine.toCharArray())
	        	hash[c]++;
	        for(char c:ransomNote.toCharArray()){
	        	if(hash[c]>0)
	        		hash[c]--;
	        	else
	        		 return false;
	        }
	        return true;
	    }
}
