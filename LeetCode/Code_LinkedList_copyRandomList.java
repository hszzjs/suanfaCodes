package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.RandomListNode;

import java.util.HashMap;

/**
 * Author:   hszzjs
 * Date:     2019/2/16 14:18
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_copyRandomList {
    /**
     * 先复制next关系，再创建HashMap
     * 很扯的一件事，真的以为使用HashMap会很简单，但是一直报错，为什么，因为HashMap放的东西地原因，一直报错。
     * key为原始节点，value为新复制的结点，然后遍历复制好的，根据base的random赋予random，一直报错。
     * 然后这里就使用key为新节点，value为旧结点，直接将旧结点的random作为新节点的random。
     * 妈的
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head){
        if (head==null) return null;
        RandomListNode res=new RandomListNode(head.label),base=head.next;
        RandomListNode r=res;
        HashMap<RandomListNode,RandomListNode> hashMap=new HashMap<>();
        hashMap.put(r,head);
        while (base!=null){
            r.next=new RandomListNode(base.label);
            hashMap.put(r.next,base);
            r=r.next;
            base=base.next;
        }
        r=res;
        base=head;
        while (r!=null){
            r.random=hashMap.get(r).random;
            base=base.next;
            r=r.next;
        }
        return res;
    }

    /**
     * 这个方法不需要额外的空间，只能利用原有数据结构，选择在原来的每个结点后面复制该结点，然后分离。所以需要三个迭代，
     * 第一个像原来的链表中插入复制的结点，第二个向新添加的结点建立random关系，第三个分离
     * @param head
     * @return
     */
    public RandomListNode copyRandomList2(RandomListNode head){
        if (head==null) return null;
        RandomListNode cur=head;
        while (cur!=null){
            RandomListNode tmp=new RandomListNode(cur.label);
            tmp.next=cur.next;
            cur.next=tmp;
            cur=cur.next.next;
        }
        cur=head;
        while (cur!=null){
            if (cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }
        cur=head;
        RandomListNode res=cur.next,copyCur=res;
        while (copyCur!=null){//分割的时候需要有循环结束条件，copCur是要取next.next，必然会在最后一个结点的时候出现故障
            cur.next=cur.next.next;
            copyCur.next=copyCur.next==null?null:copyCur.next.next;//毕竟判断.next是不是null，如果是null就要直接为null
            copyCur=copyCur.next;
            cur=cur.next;
        }
        return res;
    }
}
