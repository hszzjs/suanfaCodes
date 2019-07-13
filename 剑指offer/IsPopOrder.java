package com.company.offer;

import java.util.Objects;
import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2018/12/3 16:20
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 算法思路：
 * 栈只能先进后出，所以只有符合这个规则就可以
 * 先压入一个元素到辅助栈，如果栈元素不为空并且栈顶元素等于弹出序列的第一个元素，则弹出元素，
 * 弹出序列向后移，并继续比较，否则压入远古三向后移，继续压入元素。知道压入序列走完或弹出序列走完。
 * 然后看栈中元素个数是否为0。
 */
public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA,int[] popA){
        if(pushA==null || popA==null) return false;
        Stack<Integer> stack1=new Stack<>();
        int pushLength=pushA.length;
        int popLength=popA.length;
        int i=0;
        int j=0;
        while (i<pushLength&&j<popLength){
            stack1.push(pushA[i]);
            while (!stack1.empty() && Objects.equals(popA[j],stack1.peek())){
                stack1.pop();
                j++;
            }
            i++;
        }
        return stack1.empty();
    }
}
