package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class InveseBinaryTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
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
