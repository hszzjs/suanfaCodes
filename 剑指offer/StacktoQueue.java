package com.company.offer;

import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2018/11/27 16:36
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 参考链接：https://blog.csdn.net/qq_39322743/article/details/78670153
 * 特点：栈是先进后出，而队列先进先出
 */
public class StacktoQueue {
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();
    public void push(int node){
        stack1.add(node);
    }
    public int pop(){//这里的pop需要注意，就是栈2如果只要不是空的，那么就意思最先进入所谓队列的元素在栈2里面，栈1是后劲的
        //所以只有当栈2弹出完毕，才需要将栈1里面的数据向栈2里面挪
        if(!stack2.empty()) return stack2.pop();
        else {
            while (!stack1.empty()) stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
