package com.company.offer;


import com.company.basicStructrue.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2018/11/27 8:21
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目:输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 思路：
 * 将链表中的值依次放入栈中，然后从栈中弹出放入ArrayList即可
 */
public class printListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> out=new ArrayList<>();
        if(listNode==null) return out;
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while(!stack.isEmpty()){
            out.add(stack.pop());
        }
        return out;
    }
}
