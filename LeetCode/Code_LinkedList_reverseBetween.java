package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/16 20:25
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_reverseBetween {
    /**
     * 链表的边界条件真的很难扣 ，就必须使用例子跑一跑。对于翻转链表，本身就直到会出现向头结点前插，所以会添加一个假头，
     * 然后就是指针要插入的话就必须直到插入的前一个结点，然后要有一个移动的指针用来直到到底哪个结点要放在前面，然后就是后面删除要翻转
     * 的结点，所以需要一个指针指向移动结点的前一个。
     * 关于找到初始插入结点，要注意参数。
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head,int m,int n){
        if (head==null|| head.next==null || m==n) return head;
        ListNode aux=new ListNode(Integer.MIN_VALUE);
        aux.next=head;
        ListNode pre=aux,post=null,cur=null;
        for (int i=0;i<n;i++){//i=0的时候pre就已经是指向head了
            if (i<m-1){
                pre=pre.next;
            }else if (i==m-1){
                post=pre.next;
                cur=post.next;
            }else {
                post.next=cur.next;
                cur.next=pre.next;
                pre.next=cur;
                cur=post.next;
            }
        }
        return aux.next;
    }
}
