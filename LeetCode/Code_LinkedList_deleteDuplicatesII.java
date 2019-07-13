package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/17 11:27
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_deleteDuplicatesII {
    /**
     * 这个就是需要先根据第一个数消除多余的，然后如果多余的消除完毕，就根据判断当前第一个重复的消除每，没有就消除，消除了就继续走
     * 所以需要有第一个是否消除的标志位
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode aux=new ListNode(Integer.MAX_VALUE);
        aux.next=head;
        ListNode ppre=aux,pre=head,cur=head.next;
        boolean f=false;
        while (cur!=null){
            if (pre.val==cur.val){
                pre.next=cur.next;
                cur=pre.next;
                f=true;
            }else {
                if (f){
                    ppre.next=cur;
                    pre=cur;
                    cur=cur.next;
                    f=false;
                }else {
                    pre=pre.next;
                    ppre=ppre.next;
                    cur=cur.next;
                }
            }
        }
        if (cur==null && f==true) {
            ppre.next=cur;
        }//这个是需要注意的，就是如果链表最后几个是重复的，会出现最后的cur==null导致重复的第一个没有消除，此时f为true，所以需要判断一下
        return aux.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1),h=head;
        h.next=new ListNode(1);
        h=h.next;
        h.next=new ListNode(1);
        h=h.next;
        h.next=new ListNode(2);
        h=h.next;
        h.next=new ListNode(2);
        h=h.next;
        head=deleteDuplicates(head);
        System.out.println(head.val);
//        head=head.next;
//        System.out.println(head.val);
//        head=head.next;
//        System.out.println(head.val);
//        head=head.next;
    }
}
