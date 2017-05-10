package com.leetcode.easy;

import sun.jvmstat.perfdata.monitor.PerfStringConstantMonitor;

import java.util.LinkedList;
import java.util.Queue;

public class InveseBinaryTree {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		TreeNode root=new TreeNode(10);
		root.left=new TreeNode(15);
		TreeNode test=root.left;
		test=null;
		System.out.println(root.left.val);

	}
	public static TreeNode invertTree(TreeNode root) {
        if(root==null)
        	return null;
		Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
        	TreeNode node=q.remove();
        	TreeNode t=node.left;
        	node.left=node.right;
        	node.right=t;
        	if(node.left!=null)
        		q.add(node.left);
        	if(node.right!=null)
        		q.add(node.right);
        }
        return root;
    }
	
}
