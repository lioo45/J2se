package com.leetcode.medium;

import com.sun.java.swing.action.NextAction;

import java.awt.geom.Line2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
  Created by pro on 17/1/3.
 */
public class AddTwoNumbers2 {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

        public static void main(String[] args) {
            ListNode node1=new ListNode(1);
            ListNode node2=new ListNode(8);
            ListNode node3=new ListNode(4);

            ListNode node4=new ListNode(0);
            ListNode node5=new ListNode(4);
            ListNode node6=new ListNode(5);
            node1.next=node2;
//            node2.next=node3;

//            node4.next=node5;
//            node5.next=node6;
            ListNode result=addTwoNumbers(node1,node4);
            for (;result!=null;result=result.next){
                System.out.println(result.val);
            }

        }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carrybit=0;
        ListNode root=null;
        ListNode node=null;
        while(l1!=null&&l2!=null){
            int value=l1.val+l2.val+carrybit;
            carrybit=value>9?1:0;
            value%=10;
            if(node==null){
                node=new ListNode(value);
                root=node;
            }
            else {
                node.next = new ListNode(value);
                node = node.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode node1=l1==null?l2:l1;
        while(node1!=null){
            int value=node1.val+carrybit;
            carrybit=value>9?1:0;
            value%=10;
            node.next=new ListNode(value);
            node=node.next;
            node1=node1.next;
        }
        if(carrybit>0)
            node.next=new ListNode(carrybit);
        return root;
    }
}
