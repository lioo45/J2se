package com.leetcode;

import java.util.Arrays;

public class MinimumPathSum {
	public static void main(String[] args) {
		int  a[][]={
			{1,1,1},
			{3,3,3},
			{1,1,1}
		};
		System.out.println(minPathSum(a));
	}
	public static int minPathSum(int[][] grid) {
		 //自底向上构建结果集
		int m=grid.length;
		int n=grid[0].length;
		if(m==1&&n==1)
			return grid[0][0];
		int r[][]=new int[m][];
		for(int i=0;i<r.length;++i){
			r[i]=new int[grid[i].length];
			r[i]=Arrays.copyOf(grid[i], grid[i].length);
		}
		r[m-1][n-1]=grid[m-1][n-1];
		//初始化结果集 
		for(int i=m-1,j=n-1;i>0;--i)//向上
			r[i-1][j]+=r[i][j];
		for(int i=m-1,j=n-1;j>0;--j)//向左
			r[i][j-1]+=r[i][j];
		int i=m-2,j=n-2;
		for(;i>0&&j>0;--i,--j){//下 右
			r[i][j]+=r[i+1][j]<r[i][j+1]?r[i+1][j]:r[i][j+1];
			//向上划
			for(int k=i-1;k>=0;--k)//下 右
				r[k][j]+=r[k+1][j]<r[k][j+1]?r[k+1][j]:r[k][j+1];
			//向左划
			for(int k=j-1;k>=0;--k)//右 下
				r[i][k]+=r[i][k+1]<r[i+1][k]?r[i][k+1]:r[i+1][k];
		}
		if(i>=0&&j>=0)
			r[i][j]+=r[i+1][j]<r[i][j+1]?r[i+1][j]:r[i][j+1];
		if(i==0)//向左划
			for(int k=j-1;k>=0;--k)
				r[0][k]+=r[0][k+1]<r[1][k]?r[0][k+1]:r[1][k];
		
		if(j==0)//向上划
			for(int k=i-1;k>=0;--k)
				r[k][0]+=r[k+1][0]<r[k][1]?r[k+1][0]:r[k][1];
		
		System.out.println();
		return r[0][0];
    }
}
