package com.company.nowLeetCode;

import com.company.basicStructrue.ListNode;

public class Code_04_sortList {
    public ListNode sortList(ListNode head){
        if (head==null) return null;
        return null;
    }
    public ListNode getMedium(ListNode head){
        ListNode p=head;
        ListNode q=head;
        while (q!=null){
            p=p.next;
            q=q.next.next;
        }
        return q;
    }
}
