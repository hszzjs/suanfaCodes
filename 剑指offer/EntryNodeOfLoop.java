package com.company.offer;


import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2018/12/24 9:34
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：链表中环的入口结点
 * 参考链接：https://blog.csdn.net/shansusu/article/details/50285735
 */
public class EntryNodeOfLoop {
    /**
     * 运行时间：20ms，占用内存：9524k
     * 算法思路：就是假设有两个指针，一个步长为1，一个步长是2，所以两者向前走同时，相遇必是在环上，并且总长一个x，一个2x，
     * 然后针对两者关系有相差了n个环。然后从新两个指针一个在开始，一个在相遇点，同时步长为1前进，相遇的就是入口。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead==null||pHead.next==null) return null;
        ListNode preNode=pHead.next;
        ListNode postNode=pHead.next.next;
        while (preNode!=postNode){
            preNode=preNode.next;
            postNode=postNode.next.next;
        }
        postNode=pHead;
        while (preNode!=postNode){
            preNode=preNode.next;
            postNode=postNode.next;
        }
        return preNode;
    }
}
