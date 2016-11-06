package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class InterleavingString {
	
	public static void main(String[] args) {
		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
//		String s1="aabcc";
//		String s2="dbbca";
//		String s3="aadbbcbcac";
		String s4 = "aadbbbaccc";
		long start=System.currentTimeMillis();
		System.out.println(isInterleave(s1,s2,s3));
		long end=System.currentTimeMillis();
		System.out.println(end-start); 
		System.out.println(visited.size());
//		System.out.println(isInterleave(s1,s2,s4));
	}
	
	private static Set<Integer> visited; // The combination of i1, i2 has been visited and return false
//	public static boolean isInterleave(String s1, String s2, String s3) {
//		if(s3.length() != s1.length() + s2.length())
//			return false;
//		visited = new HashSet<Integer>();
//		return isInterleave(s1, 0, s2, 0, s3, 0);
//	}
//	
//	private static boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3)
//	{	
//		int hash = i2 * s3.length() + i1;
//		if(visited.contains(hash))
//			return false;
//		
//		if(i1 == s1.length())
//			return s2.substring(i2).equals(s3.substring(i3));
//		if(i2 == s2.length())
//			return s1.substring(i1).equals(s3.substring(i3));
//		
//		if(s3.charAt(i3) == s1.charAt(i1) && isInterleave(s1, i1+1, s2, i2, s3, i3+1) ||
//		   s3.charAt(i3) == s2.charAt(i2) && isInterleave(s1, i1, s2, i2+1, s3, i3+1))
//			return true;
//		
//		visited.add(hash);
//		return false;
//	}

//	public static boolean isInterleave(String s1, String s2, String s3) {
//		if((s1.length()+s2.length()!=s3.length()))
//			return false;
//		visited=new HashSet<Integer>();
//		return is(s1,0,s2,0,s3,0);
//	}
//	public static boolean is(String s1,int i1, String s2,int i2, String s3,int i3){
//		boolean flag;
//		int hash=i1*s3.length()+i2;
//		if(visited.contains(hash))
//			return false;
//		while(i3<s3.length()){
//			if(i1==s1.length())
//				return s2.substring(i2).equals(s3.substring(i3));
//			if(i2==s2.length())
//				return s1.substring(i1).equals(s3.substring(i3));
//    	   if(s3.charAt(i3)==s1.charAt(i1)&&s3.charAt(i3)==s2.charAt(i2)){
//    		   flag =is(s1,i1+1,s2,i2,s3,i3+1)||is(s1,i1,s2,i2+1,s3,i3+1);
//    		   if(flag==false)
//    			   visited.add(hash);
//    		   return flag;
//    	   }
//    	   if(s3.charAt(i3)==s1.charAt(i1))
//    		  i1++;
//    	   else if(s3.charAt(i3)==s2.charAt(i2))
//    		   i2++;
//    	   else{
//    		   visited.add(hash);
//    		   return false;
//    	   }
//    	   i3++;
//       }
//       return true;
//	}
//	private static Set<Integer> visited;
	 public static boolean isInterleave(String s1, String s2, String s3) {  
	        if (s1.length()+s2.length()!=s3.length()) return false;  
	        visited=new HashSet<Integer>();
	        return rec(s1,0,s2,0,s3,0);  
	    }  
	      
	    public static boolean rec(String s1, int p1, String s2, int p2, String s3, int p3){  
	    	boolean flag;
	       int hash = p2 * s3.length() + p1;
	       if(visited.contains(hash))
				return false;
		   if (p3==s3.length()) return true;  
	        if (p1==s1.length()) return s2.substring(p2).equals(s3.substring(p3));  
	        if (p2==s2.length()) return s1.substring(p1).equals(s3.substring(p3));  
	       
		   
			if (s1.charAt(p1)==s3.charAt(p3)&&s2.charAt(p2)==s3.charAt(p3))  
				flag= rec(s1,p1+1,s2,p2,s3,p3+1) || rec(s1,p1,s2,p2+1,s3,p3+1);  
			else if (s1.charAt(p1)==s3.charAt(p3))  
				flag= rec(s1,p1+1,s2,p2,s3,p3+1);  
			else if (s2.charAt(p2)==s3.charAt(p3))  
				flag= rec(s1,p1,s2,p2+1,s3,p3+1);
			else 
				flag=false;
			if(flag==false)
				visited.add(hash);
			
			return flag;
	    }  
		
}
