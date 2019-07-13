package com.company.offer;


import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2018/12/3 8:12
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 算法思路：
 * 两种方法递归与非递归，无论运行时间还是运行效率两者不相上下
 */
public class Merge {
    /**
     * 递归方法，运行时间20ms，占用内存9488k
     * @param list1
     * @param list2
     * @return
     */
    /**
    public ListNode Merge(ListNode list1,ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode newHead=null;
        if(list1.val<=list2.val){
            newHead=list1;
            newHead.next=Merge(list1.next,list2);
        }else{
            newHead=list2;
            newHead.next=Merge(list1,list2.next);
        }
        return newHead;
     */

    /**
     * 非递归方法，运行时间23ms，占用内存9556k
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode newHead=null;
        ListNode temp=null;
        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                if(newHead==null) newHead=temp=list1;
                else{
                    temp.next=list1;
                    temp=temp.next;}
                list1=list1.next;
            }else {
                if(newHead==null) newHead=temp=list2;
                else{
                    temp.next=list2;
                    temp=temp.next;}
                list2=list2.next;
            }
            if(list1==null) temp.next=list2;
            else temp.next=list1;
        }
        return newHead;
    }
}
