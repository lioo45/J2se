package com.leetcode.medium;

/**
 * Created by pro on 17/2/3.
 */
public class LinkedListCycleII142 {

       class ListNode {
           int val;
           ListNode next;
           ListNode(int x) {
               val = x;
              next = null;
          }

     }

    /*先查找环路中是否有环,无环返回null,有环则继续
    * 找到碰撞点,然后保持一次一步的速率前进直至再碰撞
    * */
    public static ListNode detectCycle(ListNode head) {
        //检测是否存在环
        if(head==null)
            return null;
        ListNode slow=head;
        ListNode fast=head;
        while(true){
            if(slow==null||fast==null)
                return null;
            fast=fast.next;
            slow=slow.next;
            if(slow==null||fast==null)
                return null;
            fast=fast.next;
            if(slow==fast)
                break;
        }
        ListNode p=head,q=slow;
        while(p!=q){
            p=p.next;
            q=q.next;
        }
        return p;
    }
}
