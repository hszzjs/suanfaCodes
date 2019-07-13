package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/17 11:59
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_mergeTwoLists {
    /**
     * 这里是选择向l1里面插入l2，因为可能涉及到向头结点其那面插，所以需要设一个假头，然后开始比较插入，
     * 唯一需要注意就是可能链表长短不一样，所以当l2较长时，需要最终判断是不是l2指的指针空了，非空就需要将剩下的结点加在l1后面
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode cur1=l1,cur2=l2,aux=new ListNode(Integer.MIN_VALUE);
        aux.next=l1;
        ListNode pre=aux;
        while (cur1!=null && cur2!=null){
            if (cur1.val<cur2.val){
                cur1=cur1.next;
            }else {
                ListNode tmp=cur2.next;
                cur2.next=cur1;
                pre.next=cur2;
                cur2=tmp;
            }
            pre=pre.next;
        }
        if (cur2!=null){
            pre.next=cur2;
        }
        return aux.next;
    }
}
