package com.leetcode.medium;

/*
 *Created by pro on 16/12/7.
 */
public class SortList148 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(3);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(2);
        ListNode n4=new ListNode(5);
        ListNode n5=new ListNode(4);
        ListNode n6=new ListNode(4);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;

        ListNode node=sortList(n1);

        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }

    }
    //归并排序
    public static ListNode sortList(ListNode head) {
        int length=1;
        ListNode node=head;
        while(node!=null&&node.next!=null){
            ++length;
            node=node.next;
        }
        if(length==1)
            return node;

        int mid=length/2;
        ListNode midNode=head;
        for (int i = 1; i <mid ; i++)
            midNode=midNode.next;
        ListNode midNext=midNode.next;
        midNode.next=null;
        //计算左半边
        ListNode left;
        left=sortList(head);
        //计算右半边
        ListNode right;
        right=sortList(midNext);
        //归并
        ListNode start;
        start=node=new ListNode(0);

        while(left!=null&&right!=null){
            if(left.val<right.val){
                node.next=left;
                node=node.next;
                left=left.next;
            }
            else{
                node.next=right;
                node=node.next;
                right=right.next;
            }
        }
        if(left==null)
            node.next=right;
        else
            node.next=left;
        return start.next;
    }
}
