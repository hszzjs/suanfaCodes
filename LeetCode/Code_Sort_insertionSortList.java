package com.company.nowLeetCode.Few;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 9:36
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Sort_insertionSortList {
    public static ListNode insertionSortList(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        ListNode pre=head,cur=head.next;
        while (cur!=null){
            if (cur.val>=pre.val){
                cur=cur.next;
                pre=pre.next;
            }else {
                ListNode l1=dummy,l2=dummy.next;
                while (l2.val<cur.val){
                    l1=l1.next;
                    l2=l2.next;
                }
                pre.next=cur.next;
                l1.next=cur;
                cur.next=l2;
                cur=pre.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(7),h=head;
        h.next=new ListNode(6);
        h=h.next;
        h.next=new ListNode(9);
        h=h.next;
        h.next=new ListNode(8);
        h=h.next;
        h.next=new ListNode(5);
        head=insertionSortList(head);
        System.out.println(head.val);
        head=head.next;
        System.out.println(head.val);
        head=head.next;
        System.out.println(head.val);
        head=head.next;
        System.out.println(head.val);
        head=head.next;
        System.out.println(head.val);
    }
}
