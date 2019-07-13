package com.company.offer;


import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2018/11/29 22:48
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：输入一个链表，输出该链表中倒数第k个结点
 * 算法思路：
 * 在链表中并不知道长度，那么就人工制造长度，首先使用一个指针到第k个结点，然后另外一个指针出发，
 * 两者同时前进，那么就会一直相距k个基点，前进到最后，就会是第二个指针就指向的倒数第k个结点
 */
public class FindKthToTail {
    /**
     * 运行时间：26ms，占用内存：9728k
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k){
        if(head==null || k<=0) return null;
        ListNode ahead=head;
        for(int i=1;i<k;i++){
            if(ahead.next!=null)
                ahead=ahead.next;
            else return null;
        }
        ListNode behind=head;
        while (ahead.next!=null){
            ahead=ahead.next;
            behind=behind.next;
        }
        return behind;
    }
}
