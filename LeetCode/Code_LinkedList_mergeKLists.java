package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2019/2/17 14:47
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_mergeKLists {
    public static ListNode mergeKLists(ArrayList<ListNode> lists){
        if (lists==null || lists.size()==0) return null;
        return mergeKL(lists,0,lists.size()-1);
    }

    public static ListNode mergeKL(ArrayList<ListNode> lists,int lo,int hi){
        if (hi<=lo) return lists.get(lo);
        int mid=lo+(hi-lo)/2;
        ListNode left = mergeKL(lists,lo,mid);
        ListNode right = mergeKL(lists,mid+1,hi);
        return mergeLists(left,right);
    }

    public static ListNode mergeLists(ListNode left,ListNode right){
        if (left==null) return right;
        if (right==null) return left;
        ListNode aux=new ListNode(Integer.MIN_VALUE);
        aux.next=left;
        ListNode ppre=aux,cur1=left,cur2=right;
        while (cur1!=null && cur2!=null){
            if (cur1.val<cur2.val){
                ppre=ppre.next;
                cur1=cur1.next;
            }else {
                ListNode next=cur2.next;
                cur2.next=ppre.next;
                ppre.next=cur2;
                ppre=ppre.next;
                cur2=next;
            }
        }
        if (cur2!=null){
            ppre.next=cur2;
        }
        return aux.next;
    }

}
