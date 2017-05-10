package com.leetcode.easy;

public class MinimumDepthofBinaryTree111 {

    public static class TreeNode {
           int val;
           TreeNode left;
           TreeNode right;
           TreeNode(int x) { val = x; }
    }
    public static int minDepth(TreeNode root) {
        if(root.left==null&&root.right==null)
            return 1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
