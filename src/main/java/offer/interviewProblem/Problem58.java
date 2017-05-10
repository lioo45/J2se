package offer.interviewProblem;

import java.util.ArrayList;
import java.util.List;

public class Problem58 {
	
	public static void main(String[] args) {
		Problem58 p=new Problem58();
		 	p.Test1();
		    p.Test2();
		    p.Test3();
		    p.Test4();
		    p.Test5();
		    p.Test6();
		    p.Test7();
		    p.Test8();
		    p.Test9();
		    p.Test10();
	}

	public  boolean isSymmetric(BinaryTreeNode root){
		List<BinaryTreeNode> list=new ArrayList<BinaryTreeNode>();
		List<BinaryTreeNode> list2=new ArrayList<BinaryTreeNode>();
		
		list.add(root);
		int left,right;
		
		BinaryTreeNode symmetric,origin;
		//当list中所有的元素为null时,mark才为false
		boolean mark=true;
		while(mark){
			left=0;
			right=list.size()-1;
			while(left<right){
				origin=list.get(left);
				symmetric=list.get(right);
				//两者中有且只有一个null时说明不匹配 
				if(origin==null&&symmetric!=null||origin!=null&&symmetric==null)
					return false;
				//两者都是null时匹配
				else if(origin==null&&symmetric==null){
					left++;
					right--;
					continue;
				}
				else{
					if(origin.data!=symmetric.data)
						return false;
			
					left++;
					right--;
				}
				
			}
			//将list的结点放入list2中
			list2.clear();
			list2.addAll(list);
			//清空list并将list中的原来结点的所有孩子放入list中
			list.clear();
			for(int i=0;i<list2.size();++i){
				origin=list2.get(i);
				if(origin==null){
					list.add(null);
					list.add(null);
					continue;
				}
				else	
					list.add(origin.lchild);
					list.add(origin.rchild);
			}
			//如果list中的所有元素为null则mark=false退出最大的while循环
			mark=false;
			for(int i=0;i<list.size();++i){
				if(list.get(i)!=null){
					mark=true;
					break;
				}
					
			}
		}
		return true;
	}
	BinaryTreeNode  CreateBinaryTreeNode(int data){
		return new BinaryTreeNode(data);
	}
	void ConnectTreeNodes(BinaryTreeNode root, BinaryTreeNode lchild, BinaryTreeNode rchild){
	    if(root != null){
	    	root.lchild=lchild;
	    	root.rchild=rchild;
	    }
	}
	
	private static class BinaryTreeNode{
		int data;
		BinaryTreeNode lchild;
		BinaryTreeNode rchild;
		
		public BinaryTreeNode(int data){
			this.data=data;
			this.lchild=null;
			this.rchild=null;
		}
		
		
	}
	void Test(String testName, BinaryTreeNode pRoot, boolean expected)
	{
	    if(testName != null)
	        System.out.printf("%s begins: ", testName);

	    if(isSymmetric(pRoot) == expected)
	        System.out.printf("Passed.\n");
	    else
	        System.out.println("FAILED.\n");
	}

//	            8
//	        6      6
//	       5 7    7 5
	void Test1()
	{
	    BinaryTreeNode pNode8 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNode61 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode62 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode51 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode71 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode72 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode52 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNode8, pNode61, pNode62);
	    ConnectTreeNodes(pNode61, pNode51, pNode71);
	    ConnectTreeNodes(pNode62, pNode72, pNode52);

	    Test("Test1", pNode8, true);

	}

//	            8
//	        6      9
//	       5 7    7 5
	void Test2()
	{
	    BinaryTreeNode pNode8 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNode61 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode9 = CreateBinaryTreeNode(9);
	    BinaryTreeNode pNode51 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode71 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode72 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode52 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNode8, pNode61, pNode9);
	    ConnectTreeNodes(pNode61, pNode51, pNode71);
	    ConnectTreeNodes(pNode9, pNode72, pNode52);

	    Test("Test2", pNode8, false);

	}

//	            8
//	        6      6
//	       5 7    7
	void Test3()
	{
	    BinaryTreeNode pNode8 = CreateBinaryTreeNode(8);
	    BinaryTreeNode pNode61 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode62 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode51 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode71 = CreateBinaryTreeNode(7);
	    BinaryTreeNode pNode72 = CreateBinaryTreeNode(7);

	    ConnectTreeNodes(pNode8, pNode61, pNode62);
	    ConnectTreeNodes(pNode61, pNode51, pNode71);
	    ConnectTreeNodes(pNode62, pNode72, null);

	    Test("Test3", pNode8, false);

	}

//	               5
//	              / \
//	             3   3
//	            /     \
//	           4       4
//	          /         \
//	         2           2
//	        /             \
//	       1               1
	void Test4()
	{
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode31 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode32 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode41 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode42 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode21 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNode22 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNode11 = CreateBinaryTreeNode(1);
	    BinaryTreeNode pNode12 = CreateBinaryTreeNode(1);

	    ConnectTreeNodes(pNode5, pNode31, pNode32);
	    ConnectTreeNodes(pNode31, pNode41, null);
	    ConnectTreeNodes(pNode32, null, pNode42);
	    ConnectTreeNodes(pNode41, pNode21, null);
	    ConnectTreeNodes(pNode42, null, pNode22);
	    ConnectTreeNodes(pNode21, pNode11, null);
	    ConnectTreeNodes(pNode22, null, pNode12);

	    Test("Test4", pNode5, true);

	}


//	               5
//	              / \
//	             3   3
//	            /     \
//	           4       4
//	          /         \
//	         6           2
//	        /             \
//	       1               1
	void Test5()
	{
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode31 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode32 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode41 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode42 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode6 = CreateBinaryTreeNode(6);
	    BinaryTreeNode pNode22 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNode11 = CreateBinaryTreeNode(1);
	    BinaryTreeNode pNode12 = CreateBinaryTreeNode(1);

	    ConnectTreeNodes(pNode5, pNode31, pNode32);
	    ConnectTreeNodes(pNode31, pNode41, null);
	    ConnectTreeNodes(pNode32, null, pNode42);
	    ConnectTreeNodes(pNode41, pNode6, null);
	    ConnectTreeNodes(pNode42, null, pNode22);
	    ConnectTreeNodes(pNode6, pNode11, null);
	    ConnectTreeNodes(pNode22, null, pNode12);

	    Test("Test5", pNode5, false);

	}

//	               5
//	              / \
//	             3   3
//	            /     \
//	           4       4
//	          /         \
//	         2           2
//	                      \
//	                       1
	void Test6()
	{
	    BinaryTreeNode pNode5 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode31 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode32 = CreateBinaryTreeNode(3);
	    BinaryTreeNode pNode41 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode42 = CreateBinaryTreeNode(4);
	    BinaryTreeNode pNode21 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNode22 = CreateBinaryTreeNode(2);
	    BinaryTreeNode pNode12 = CreateBinaryTreeNode(1);

	    ConnectTreeNodes(pNode5, pNode31, pNode32);
	    ConnectTreeNodes(pNode31, pNode41, null);
	    ConnectTreeNodes(pNode32, null, pNode42);
	    ConnectTreeNodes(pNode41, pNode21, null);
	    ConnectTreeNodes(pNode42, null, pNode22);
	    ConnectTreeNodes(pNode21, null, null);
	    ConnectTreeNodes(pNode22, null, pNode12);

	    Test("Test6", pNode5, false);

	}

	// Only one node
	void Test7()
	{
	    BinaryTreeNode pNode1 = CreateBinaryTreeNode(1);
	    Test("Test7", pNode1, true);

	}

	// No nodes
	void Test8()
	{
	    Test("Test8", null, true);
	}

	// All nodes have the same value
//	               5
//	              / \
//	             5   5
//	            /     \
//	           5       5
//	          /         \
//	         5           5
	void Test9()
	{
	    BinaryTreeNode pNode1 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode21 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode22 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode31 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode32 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode41 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode42 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNode1, pNode21, pNode22);
	    ConnectTreeNodes(pNode21, pNode31, null);
	    ConnectTreeNodes(pNode22, null, pNode32);
	    ConnectTreeNodes(pNode31, pNode41, null);
	    ConnectTreeNodes(pNode32, null, pNode42);
	    ConnectTreeNodes(pNode41, null, null);
	    ConnectTreeNodes(pNode42, null, null);

	    Test("Test9", pNode1, true);

	}

	// All nodes have the same value
//	               5
//	              / \
//	             5   5
//	            /     \
//	           5       5
//	          /       /
//	         5       5
	void Test10()
	{
	    BinaryTreeNode pNode1 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode21 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode22 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode31 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode32 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode41 = CreateBinaryTreeNode(5);
	    BinaryTreeNode pNode42 = CreateBinaryTreeNode(5);

	    ConnectTreeNodes(pNode1, pNode21, pNode22);
	    ConnectTreeNodes(pNode21, pNode31, null);
	    ConnectTreeNodes(pNode22, null, pNode32);
	    ConnectTreeNodes(pNode31, pNode41, null);
	    ConnectTreeNodes(pNode32, pNode42, null);
	    ConnectTreeNodes(pNode41, null, null);
	    ConnectTreeNodes(pNode42, null, null);

	    Test("Test10", pNode1, false);

	}
}
