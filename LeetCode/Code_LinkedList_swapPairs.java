package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/17 14:15
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_swapPairs {
    /**
     * 题目较简单，只要注意就可以
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        ListNode ppre=dummy,pre=head,cur=head.next;
        boolean f=true;
        while (cur!=null){
            if (f){
                pre.next=cur.next;
                cur.next=ppre.next;
                ppre.next=cur;
                f=false;
                cur=pre.next;
            }else {
                f=true;
                cur=cur.next;
                pre=pre.next;
            }
            ppre=ppre.next;
        }
        return dummy.next;
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
//        h=h.next;
//        h.next=new ListNode(6);
        head=swapPairs(head);
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
