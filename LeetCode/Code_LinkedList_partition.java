package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/17 10:16
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_partition {
    /**
     * 说明下题意就是将链表分为两部分，一部分是比x小的，一部分是大于等于x的，要保证结点相对位置不变。
     * 这个是很简单的做法，直接两个链表分别放小的和大的，最后拼在一起
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head,int x){
        if (head==null || head.next==null) return head;
        ListNode sh=new ListNode(Integer.MIN_VALUE),s=sh;
        ListNode bh=new ListNode(Integer.MAX_VALUE),b=bh;
        ListNode cur=head;
        while (cur!=null){
//            System.out.println(cur.val);
            if (cur.val<x){
                s.next=new ListNode(cur.val);
                s=s.next;
            }else {
                b.next=new ListNode(cur.val);
                b=b.next;
            }
            cur=cur.next;
        }
        s.next=bh.next;
        return sh.next;
    }

    public static void main(String[] args) {
        ListNode h=new ListNode(1);
        h.next=new ListNode(1);
        System.out.println(partition(h,0).next.val);
    }
}
