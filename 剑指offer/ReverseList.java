package com.company.offer;


import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2018/11/30 8:35
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：输入一个链表，反转链表后，输出新链表的表头
 * 算法思路：
 * 就是使用三个指针，head本身占用一个指针，然后就是head前面的反转使用pre指针，
 * pre就可以类似是前面n个已经反转的，只要当前结点的next给到它就可以，但是head表征当前结点，
 * next已经给出去了，如何得到原来的剩余结点，就需要一个指针来暂存。
 */
public class ReverseList {
    /**
     * 运行时间19ms，占用内存：9476k
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head){
        if (head==null) return null;
        ListNode pre=null;
        ListNode next;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
