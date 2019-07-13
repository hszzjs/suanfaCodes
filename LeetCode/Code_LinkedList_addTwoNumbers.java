package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/17 20:02
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_addTwoNumbers {
    /**
     * 这题就是扣边界，主要在于如果l1与l2长度不等，是在whi里面处理，毕竟如果都是9会涉及到进位的问题
     * 所以while条件是l1与l2两个指针只要有一个非空就要继续加，怎么加，创建0结点
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode head=l1,pre=l1;
        int t=0;
        while (l1!=null || l2!=null){
            if (l1==null){
                pre.next=new ListNode(0);
                l1=pre.next;
            }
            if (l2==null){
                l2=new ListNode(0);
            }
            if (l1.val+l2.val+t<10){
                l1.val=l1.val+l2.val+t;
                t=0;
            }else {
                l1.val=l1.val+l2.val+t-10;
                t=1;
            }
            pre=l1;
            l1=l1.next;
            l2=l2.next;
        }
        if (t==1){
            pre.next=new ListNode(1);
        }
        return head;
    }

    public static ListNode reverse(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode aux=new ListNode(Integer.MIN_VALUE);
        aux.next=head;
        ListNode ppre=aux,pre=head,cur=head.next;
        while (cur!=null){
            pre.next=cur.next;
            cur.next=ppre.next;
            ppre.next=cur;
            cur=pre.next;
        }
        return aux.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(9),h=head;
//        h.next=new ListNode(2);
//        h=h.next;
//        h.next=new ListNode(5);
//        h=h.next;
        h.next=new ListNode(8);
        ListNode head1=new ListNode(1);
//        h=head1;
//        h.next=new ListNode(4);
//        h=h.next;
//        h.next=new ListNode(5);
        head=addTwoNumbers(head,head1);
        System.out.println(head.val);
        head=head.next;
        System.out.println(head.val);
//        head=head.next;
//        System.out.println(head.val);
//        head=head.next;
//        System.out.println(head.val);
//        head=head.next;
//        System.out.println(head.val);
//        head=head.next;
//        System.out.println(head.val);
    }
}
