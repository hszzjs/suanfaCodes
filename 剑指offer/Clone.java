package com.company.offer;


import com.company.basicStructrue.RandomListNode;

/**
 * Author:   hszzjs
 * Date:     2018/12/4 14:20
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 算法思路：
 * 这道题比较复杂，需要画图才能理解。
 */
public class Clone {
    /**
     * 运行时间30ms，占用内存：9356k
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null) return null;
        RandomListNode p=pHead;
        RandomListNode q=pHead;
        while (p!=null){
            RandomListNode cpNode=new RandomListNode(p.label);
            cpNode.next=p.next;
            p.next=cpNode;
            p=cpNode.next;//p用来存放next域
        }
        while (q!=null){//q存放Random域
            RandomListNode t=q.next;
            if(q.random!=null)
                t.random=q.random.next;
            q=t.next;
        }
        RandomListNode s=pHead.next;
        RandomListNode s1=pHead;
        RandomListNode temp=null;
        while (s1.next!=null){//这里的重点是要挨个拆，不能说只是中断其中的一部分。
            temp=s1.next;
            s1.next=temp.next;
            s1=temp;
        }
        return s;
    }
}
