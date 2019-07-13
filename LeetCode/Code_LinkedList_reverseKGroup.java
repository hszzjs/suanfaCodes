package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/17 13:12
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_reverseKGroup {
    /**
     * 题目意思就是从头开始，每k个结点就翻转一次，如果最后剩下的不足k个那就不翻转了。
     * 由于从头开始翻转，所以需要创建一个假结点，然后需要计数君，关键就是如何翻转，需要创建一个翻转函数，函数输入两个指针，
     * 需要翻转段的前一个指针pre，翻转段的后一个指针end，由于反转后不需要进行任何操作对于翻转区域，所以直接返回的是翻转区域的最后一个指针，
     * 然后就是翻转区域的最后一个指针要链上之前的end，以免出现断裂
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head,int k){
        if (k==0 || head==null || k==1 || head.next==null) return head;
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        int cnt=1;
        ListNode pre=dummy,cur=head;
        while (cur!=null){
            if (cnt==k){
                pre=reverse(pre,cur.next);
                cur=pre.next;
                cnt=1;
            }else {
                cnt++;
                cur=cur.next;
            }
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode begin,ListNode end){
        if (begin==end) return end;
        ListNode pre=begin,cur=pre.next,p=cur.next;
        ListNode head=pre.next;
        while (p!=end){
            cur.next=p.next;
            p.next=pre.next;
            pre.next=p;
            p=cur.next;
        }
        head.next=end;
        return head;
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
        head=reverseKGroup(head,4);
        System.out.println(head.val);
        head=head.next;
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
