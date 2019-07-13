package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/16 13:13
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_hasCycle {
    /**
     * 这道题很简单，就是使用快慢指针，好比在跑圈，快的人总是会追上慢的人，也就是快慢指针相遇，毕竟如果有环，快的指针必然一直在环中绕，
     * 一旦慢指针进入环，二者必回相遇
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head){
        if (head==null || head.next==null || head.next.next==null) return false;
        ListNode p=head,q=head;
        while (q.next!=null && q.next.next!=null){
            p=p.next;
            q=q.next.next;
            if (p==q) return true;
        }
        return false;
    }
}
