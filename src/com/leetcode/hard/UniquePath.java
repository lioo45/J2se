package com.leetcode;

public class UniquePath {
	public static void main(String[] args) {
		System.out.println(uniquePaths(3,3));
	}

	public static int uniquePaths(int m, int n) {
        //自底向上构建结果集
		if(m==1&&n==1)
			return 1;
		int r[][]=new int[m][n];
		//初始化结果集 
		for(int i=m-1,j=n-1;i>0;--i)
			r[i-1][j]=1;
		for(int i=m-1,j=n-1;j>0;--j)
			r[i][j-1]=1;
		int i=m-2,j=n-2;
		for(;i>0&&j>0;--i,--j){
			r[i][j]=r[i+1][j]+r[i][j+1];
			//向上划
			for(int k=i-1;k>=0;--k)
				r[k][j]=r[k+1][j]+r[k][j+1];
			//向左划
			for(int k=j-1;k>=0;--k)
				r[i][k]=r[i][k+1]+r[i+1][k];
		}
		if(i>=0&&j>=0)
			r[i][j]=r[i+1][j]+r[i][j+1];
		if(i==0)//向左划
			for(int k=j-1;k>=0;--k)
				r[0][k]=r[0][k+1]+r[1][k];
		
		if(j==0)//向上划
			for(int k=i-1;k>=0;--k)
				r[k][0]=r[k+1][0]+r[k][1];
		
		System.out.println();
		return r[0][0];
    }
}
