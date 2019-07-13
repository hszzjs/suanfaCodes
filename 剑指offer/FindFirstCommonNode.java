package com.company.offer;

import com.company.basicStructrue.ListNode;

import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2018/12/17 13:11
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：输入两个链表，找出它们的第一个公共结点。
 * 参考链接：https://blog.csdn.net/qq_23031939/article/details/82193713
 */
public class FindFirstCommonNode {
    /**
     * 运行时间：30ms，占用内存：9592k
     * 算法思路：就是使用hashset，先将第一个链表的所有结点放入，
     * 然后开始遍历第二个结点，看hashset里面包含不，包含就返回该结点，不包含那就返回null
     * @param pHead1
     * @param pHead2
     * @return
     */
    /**
    public ListNode FindFirstCommonNode(ListNode pHead1,ListNode pHead2){
        ListNode current1=pHead1;
        ListNode current2=pHead2;
        HashSet<ListNode> hashSet=new HashSet<>();
        while (current1!=null){
            hashSet.add(current1);
            current1=current1.next;
        }
        while (current2!=null){
            if (hashSet.contains(current2)) return current2;
            current2=current2.next;
        }
        return null;
    }
     */
    /**
     * 运行时间：25ms，占用内存：9652k
     * 算法思路：这里利用了栈先进后出的特点，就是只要有一个结点相同，那就意味着该结点极其next的所有都是相等的，
     * 所以直到不等的那里就是找到了结点，而且如果最后一个结点都不等，就意味没有结点相等
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
        if(pHead1==null||pHead2==null) return null;
        Stack<ListNode> s1=new Stack<>();
        Stack<ListNode> s2=new Stack<>();
        while (pHead1!=null){
            s1.push(pHead1);
            pHead1=pHead1.next;
        }
        while (pHead2!=null){
            s2.push(pHead2);
            pHead2=pHead2.next;
        }
        ListNode firstNode=null;
        while (!s1.isEmpty()&&!s2.isEmpty()&&s1.peek()==s2.peek()){
            s1.pop();
            firstNode=s2.pop();
        }
        return firstNode;
    }
}
