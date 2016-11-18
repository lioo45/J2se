package com.leetcode;

public class InterleavingStringWithMatrix {
	public static void main(String[] args) {
		String s1="aabcc";
		String s2="dbbca";
		String s3="aadbbcbcac";
//		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
//		String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
//		String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		String s4 = "aadbbbaccc";
		long start=System.currentTimeMillis();
		System.out.println(isInterleave(s1,s2,s3));
		System.out.println(isInterleave(s1,s2,s4));
		long end=System.currentTimeMillis();
		System.out.println(end-start); 
	}
	public static boolean isInterleave(String s1,String s2,String s3) {
        int m=s1.length();
        int n=s2.length();
        if(m+n!=s3.length())
        	return false;
        boolean result[][]=new boolean[m+1][n+1];
        result[m][n]=true;
        for(int j=n-1;j>=0;--j)//初始边界条件 向左扫
        	result[m][j]=s2.charAt(j)==s3.charAt(m+j)?result[m][j+1]:false;
        for(int i=m-1;i>=0;--i)//初始边界条件 向上扫
        	result[i][n]=s1.charAt(i)==s3.charAt(n+i)?result[i+1][n]:false;
        for(int i=m-1;i>=0;--i)//开始求解
        	for(int j=n-1;j>=0;--j)
        		result[i][j]=s1.charAt(i)==s3.charAt(i+j)&&result[i+1][j]
        				||s2.charAt(j)==s3.charAt(i+j)&&result[i][j+1];
        return result[0][0];
    }
	/*上面那个解法 有一个缺陷 即当子问题不匹配发生时 函数依然工作 不返回 
	 *所以如果想让
	 */

}
