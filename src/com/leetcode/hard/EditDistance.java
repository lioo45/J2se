package com.leetcode;

public class EditDistance {
	public static void main(String[] args) {
		System.out.println(minDistance("abcde","123456"));
	}
	public static int minDistance(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        int result[][]=new int[m+1][n+1];
        //初始边界条件
        for(int j=n,v=0;j>=0;--j,++v)
        	result[m][j]=v;
        for(int i=m,v=0;i>=0;--i,++v)
        	result[i][n]=v;
       //开始求解
        for(int i=m-1,j=n-1;i>=0&&j>=0;--i,--j){
        	result[i][j]=s1.charAt(i)==s2.charAt(j)?result[i+1][j+1]:
        			1+Min(result[i+1][j],result[i][j+1],result[i+1][j+1]);
        	for(int k=j-1;k>=0;--k)//向左扫
        		result[i][k]=s1.charAt(i)==s2.charAt(k)?result[i+1][k+1]:
        		1+Min(result[i+1][k],result[i][k+1],result[i+1][k+1]);
        	for(int k=i-1;k>=0;--k)//向上扫
        		result[k][j]=s1.charAt(k)==s2.charAt(j)?result[k+1][j+1]:
        		1+Min(result[k+1][j],result[k][j+1],result[k+1][j+1]);
        }
        return result[0][0];
    }
	
	public static int Min(int a,int b,int c){
		if(a<=b){
			if(a<=c)
				return a;
			else{
				if(c<=b)
					return c;
			}
		}
		return b;
	}
}
