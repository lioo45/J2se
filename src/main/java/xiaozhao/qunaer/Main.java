package xiaozhao.qunaer;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by pro on 17/4/1.
 */
public class Main {

    static   class TreeNode{
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            //读取输入数据
            int n=sc.nextInt();
            int[] preorder=new int[n];
            int[] inorder=new int[n];
            for (int i = 0; i <n ; i++)
                preorder[i]=sc.nextInt();
            for (int i = 0; i <n ; i++) {
                inorder[i]=sc.nextInt();
            }
            //构造二叉树
            TreeNode root=buildTree(preorder,inorder);
            Queue<TreeNode> queue=new LinkedList<TreeNode>();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode node=queue.remove();
                System.out.print(node.value+" ");
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }
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
