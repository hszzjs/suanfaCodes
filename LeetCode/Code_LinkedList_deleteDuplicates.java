package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

import java.util.HashMap;

/**
 * Author:   hszzjs
 * Date:     2019/2/17 10:49
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_deleteDuplicates {
    /**
     * 这里借助HashMap来讲已经出现过的数值保存起来
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head){
        if (head==null || head.next==null) return head;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        ListNode aux=new ListNode(Integer.MIN_VALUE);
        aux.next=head;
        ListNode cur=head,pre=aux;
        while (cur!=null){
            if (!hashMap.containsKey(cur.val)){
                hashMap.put(cur.val,1);
                pre=pre.next;
                cur=cur.next;
            }else {
                pre.next=cur.next;
                cur=pre.next;
            }
        }
        return aux.next;
    }

    /**
     * 之前忽略了一个重要的信息就是，这个链表是有序链表，所以可以只使用双指针，不使用HashMap
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode cur=head.next,pre=head;
        while (cur!=null){
            if (cur.val!=pre.val){
                cur=cur.next;
                pre=pre.next;
            }else {
                pre.next=cur.next;
                cur=pre.next;
            }
        }
        return head;
    }
}
