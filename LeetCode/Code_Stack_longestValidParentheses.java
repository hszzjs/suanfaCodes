package com.company.nowLeetCode.Stack;

import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2019/2/18 13:56
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Stack_longestValidParentheses {
    /**
     * 这个题的测试用例简直太刁钻了。这个的关键就是栈里面存的是索引，太有用了，毕竟就是小括号，很没有用用栈来存
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s){
        int len=0,start=0;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                stack.push(i);
            }else if (stack.isEmpty()){
                start=i+1;
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    len=Math.max(len,i-start+1);
                }else {
                    len=Math.max(i-stack.peek(),len);//这里是索引，所以如果栈不为空，start没有更新，
                    // 这里就直接使用stack的顶部的索引来获取长度
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        String s="((((())()(((()))";
        System.out.println(longestValidParentheses(s));
    }
}
