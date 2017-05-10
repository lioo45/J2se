package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {
      public static class TreeNode {
              int val;
              TreeNode left;
              TreeNode right;
              TreeNode(int x) { val = x; }
      }

    public static void main(String[] args) {
        List<TreeNode> list=generateTrees(3);

    }
    public static  List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> lists= new ArrayList<List<TreeNode>>();
        List<TreeNode> list0=new ArrayList<TreeNode>();
        list0.add(null);
        lists.add(0,list0);
        if(n==0)
            return lists.get(0);
        List list1=new ArrayList<TreeNode>();
        list1.add(new TreeNode(1));
        lists.add(1,list1);
        for (int i = 2; i <= n; i++) {
            List<TreeNode> list=new ArrayList<TreeNode>();
            for (int j = i - 1; j >= 0; --j){
                List<TreeNode> listj1=lists.get(j);
                List<TreeNode> listj2=lists.get(i-j-1);
                for(TreeNode node1:listj1){
                    for(TreeNode node2:listj2){
                        TreeNode node=new TreeNode(j+1);
                        node.left=node1;
                        node.right=clone(node2,j+1);
                        list.add(node);
                    }
                }
            }
            lists.add(i,list);
        }
        return lists.get(lists.size()-1);
    }
    protected static TreeNode clone(TreeNode root,int base) {
        if(root==null)
            return null;
        TreeNode node=new TreeNode(root.val+base);
        node.left=clone(root.left,base);
        node.right=clone(root.right,base);
        return node;
    }
}
