package com.company.offer;

import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2018/12/3 16:01
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 算法思路：
 * 当最小元素弹出后，min就需要相应改变，所以必须把每次的最小值都存储下来。考虑采用一个辅助栈来存放最小值：
 * 栈  3，4，2，5，1
 * 辅助栈 3， 3，2，2，1
 * （压入时，把每次的最小元素（之前最小元素与新入栈元素的较小值）保存起来放到辅助栈中）
 * 参考链接：https://blog.csdn.net/lilianforever/article/details/51849488，http://www.cnblogs.com/yongh/p/9804934.html
 */
public class minStack {
    Stack<Integer> stack_data=new Stack<>();
    Stack<Integer> stack_min=new Stack<>();
    public void push(int node){
        stack_data.push(node);
        if(stack_min.empty()||stack_min.peek()>node){
            stack_min.push(node);
        }else{
            stack_min.push(stack_min.peek());
        }
    }

    public void pop(){
        if(!stack_data.empty()){
            stack_data.pop();
            stack_min.pop();
        }
    }

    public int top(){
        return (int)stack_data.peek();
    }

    public int min(){
        return stack_min.peek();
    }
}
