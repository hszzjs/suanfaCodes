package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2019/2/17 19:50
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_removeNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head,int n){
        if (n==0 || head==null  ) return head;
        ListNode aux=new ListNode(Integer.MIN_VALUE);
        aux.next=head;
        ListNode pre=head,cur=head,ppre=head;
        for (int i=0;i<n;i++){
            pre=pre.next;
        }
        if (pre==null) return head.next;
        while (pre!=null){
            ppre=cur;
            pre=pre.next;
            cur=cur.next;
        }
        ppre.next=cur.next;
        return aux.next;
    }


    public static void main(String[] args) {
        ListNode head=new ListNode(1),h=head;
        h.next=new ListNode(2);
        h=h.next;
        h.next=new ListNode(3);
        h=h.next;
        h.next=new ListNode(4);
        h=h.next;
        h.next=new ListNode(5);
        h=h.next;
        h.next=new ListNode(6);
//        head=removeNthFromEnd(new ListNode(1),1);
        System.out.println(head.val);
        head=head.next;
        System.out.println(head.val);
        head=head.next;
        System.out.println(head.val);
        head=head.next;
        System.out.println(head.val);
        head=head.next;
        System.out.println(head.val);
//        head=head.next;
//        System.out.println(head.val);
    }
}
