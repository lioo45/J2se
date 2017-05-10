package com.leetcode.medium;



public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {

    public static  class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public static void main(String[] args) {
        int[] pre={1,2,4,3,5,6};
        int[] in={4,2,1,5,3,6};
        TreeNode node=buildTree(pre,in);
        traval(node);
        System.out.println();
        preTraval(node);
    }

    public static void traval(TreeNode root){
        if(root==null)
            return ;
        traval(root.left);
        System.out.print(root.val);
        traval(root.right);
    }

    public static void preTraval(TreeNode root){
        if(root==null)
            return ;
        System.out.print(root.val);
        preTraval(root.left);
        traval(root.right);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length<=0||inorder.length<=0||preorder.length!=inorder.length)
            return null;

        return helpBuild(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public static TreeNode helpBuild(int[] preorder,int pleft,int pright,
                                     int[] inorder,int ileft,int iright){
        TreeNode root=new TreeNode(preorder[pleft]);
        //划分左右子树的前序中序
        int mid;
        for (mid = ileft; mid <=iright ; mid++) {
            if(inorder[mid]==preorder[pleft])
                break;
        }
        int leftLen=mid-ileft;
        int rightLen=iright-mid;


        root.left=leftLen<=0?null:helpBuild(preorder,pleft+1,pleft+leftLen,
                inorder,ileft,ileft+leftLen-1);

        root.right=rightLen<=0?null:helpBuild(preorder,pleft+leftLen+1,pleft+leftLen+rightLen,
                inorder,ileft+leftLen+1,iright);
        return root;
    }


}
