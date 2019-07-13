package com.company.nowLeetCode.Stack;

import java.util.Stack;

public class Code_Stack_evalRPN {
    /**
     * 就字符串判断相等要用equals不要直接用==，否则出错
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens){
        if (tokens==null || tokens.length==0) return 0;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<tokens.length;i++){
            String tmp=tokens[i];
            if (!tmp.equals("*") && !tmp.equals("/") && !tmp.equals("+") && !tmp.equals("-")){
                stack.push(Integer.valueOf(tokens[i]));
            }else {
                int m=stack.pop();
                int n=stack.pop();
                int res=tmp.equals("*")?m*n:(tmp.equals("/")?n/m:(tmp.equals("-")?n-m:m+n));
                stack.push(res);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens=new String[]{"0","3","/"};
        System.out.println(evalRPN(tokens));
    }
}
