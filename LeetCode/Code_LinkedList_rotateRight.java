package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/17 12:17
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_rotateRight {
    /**
     * 题目说得简单，但是题是这样的，从右至左数k个然后旋转，主要是存在k可能大于链表本身长度，如果太长就需要将k除以长度取余数
     * 然后就是边界，怎么才能准确取到第k个的边界
     * @param head
     * @param n
     * @return
     */
    public static ListNode rotateRight(ListNode head,int n){
        if (n==0 || head==null || head.next==null) return head;
        ListNode cur=head,pre=head,ppre=null;
        int len=0;
        for (int i=0;i<n;i++){
            cur=cur.next;
            len++;
            if (cur==null) {
                n=n%len;
                return rotateRight(head,n);
            }
        }
        ListNode tmp=null;
        while (cur!=null){
            ppre=cur;
            tmp=pre;
            cur=cur.next;
            pre=pre.next;
        }
        tmp.next=null;
        ppre.next=head;
        return pre;
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
        head=rotateRight(head,7);
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
