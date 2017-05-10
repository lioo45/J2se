package interview;

import java.util.ArrayList;
/**
 * Created by pro on 17/2/9.
 */
public class P54_4_9 {

    public static void main(String[] args) {

    }
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }
    /*对每一个节点进行深度优先遍历,符合条件的输出,一旦大于则该路径上不在深度遍历*/
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
        traval(root,target,lists);
        return lists;
    }

    public static void traval(TreeNode root,int target,
                              ArrayList<ArrayList<Integer>> lists){
        if(root==null)
            return ;
        DFS(root,target,0,new ArrayList<Integer>(),lists);
        traval(root.left,target,lists);
        traval(root.right,target,lists);
    }

    public static boolean DFS(TreeNode root,int target,int currentVal,
                           ArrayList<Integer> result,ArrayList<ArrayList<Integer>> lists){
        if(root==null)
            return false;
        currentVal+=root.val;
        result.add(root.val);
        if(currentVal==target){
            lists.add(new ArrayList<Integer>(result));
            result.remove(result.size()-1);
            return true;
        }
        if(currentVal<target){
            DFS(root.left,target,currentVal,result,lists);
            DFS(root.right,target,currentVal,result,lists);
        }
        //currentVal>target
        result.remove(result.size()-1);
        return false;
    }
}
