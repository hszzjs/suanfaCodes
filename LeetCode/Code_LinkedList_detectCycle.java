package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/16 13:25
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_detectCycle {
    /**
     * 这个就是相遇后，两个指针部署一样，那么将其中一个指针指向头结点，下次相遇的地方就是环的入口处
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head){
        if (head==null || head.next==null || head.next.next==null) return null;
        ListNode p=head,q=head;
        while (q.next!=null && q.next.next!=null){
            q=q.next.next;
            p=p.next;
            if (p==q) break;
        }
        if (q.next==null || q.next.next==null) return null;
        p=head;
        while (p!=q){
            p=p.next;
            q=q.next;
        }
        return p;
    }
}
