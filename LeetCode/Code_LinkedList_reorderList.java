package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/16 8:53
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_reorderList {
    /**
     * 搞错题了，这个是简单版本的。1234==》1324
     * @param head
     */
    public void reorderListwrong(ListNode head){
        if (head==null || head.next==null || head.next.next==null) return;
        ListNode mid=head,p=head;
        while (p.next!=null && p.next.next!=null){
            mid=mid.next;
            p=p.next.next;
        }
        p=head;
        while (mid.next!=null){
            ListNode q=p.next;
            p.next=mid.next;
            p=p.next;
            p.next=q;
            p=q;
            mid=mid.next;
        }
        p.next=null;
    }

    /**
     * 正式题目，就是重点在于翻转链表
     * @param head
     */
    public void reorderList(ListNode head){
        if (head==null || head.next==null || head.next.next==null) return;
        ListNode mid=head,second=head;
        while (second.next!=null && second.next.next!=null){
            mid=mid.next;
            second=second.next.next;
        }
        second=mid.next;
        mid.next=null;
        second=reverse(second);
        ListNode first=head;
        while (second!=null){
            ListNode next=first.next;
            first.next=second;
            second=second.next;
            first=first.next;
            first.next=next;
            first=first.next;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode pre=null;//pre作为翻转链表的头结点
        ListNode next=null;
        while (head!=null){//head作为剩下链表的头结点
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
