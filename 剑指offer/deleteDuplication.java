package com.company.offer;


import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2018/12/26 13:05
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：删除链表中的重复的结点
 */
public class deleteDuplication {
    /**
     * 运行时间：21ms，占用内存：9664k
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead){
        ListNode first=new ListNode(-1);
        first.next=pHead;
        ListNode p=pHead;
        //用户删除重复结点的结点
        ListNode last=first;
        while (p!=null&&p.next!=null){
            if(p.val == p.next.val){
                int val=p.val;
                while (p!=null&&p.val==val)//双与要判断下前后关系
                    p=p.next;
                last.next=p;
            }else {
                last=p;
                p=p.next;
            }
        }
        return first.next;
    }
}
