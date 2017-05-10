package com.leetcode.easy;

public class SumOfLeftLeaves {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static int sumOfLeftLeaves(TreeNode root) {
       int[] sum=new int[1];
       sum[0]=0;
       foo(root,sum);
       return sum[0];
    }
	public static void foo(TreeNode root,int sum[]){
		 if(root==null)
	        	return ;
	        foo(root.left,sum);
	        if(root.left!=null&&root.left.right==null&&root.left.left==null)
	        	sum[0]+=root.left.val;
	        foo(root.right,sum);
	}
}
