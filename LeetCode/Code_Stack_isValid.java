package com.company.nowLeetCode.Stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2019/2/18 14:15
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Stack_isValid {
    public static boolean isValid(String s){
        Stack<String> stack=new Stack<>();
        HashMap<String ,String > hashMap=new HashMap<>();
        hashMap.put("(",")");
        hashMap.put("[","]");
        hashMap.put("{","}");
        for (int i=0;i<s.length();i++){
            String tmp=s.substring(i,i+1);
            if (tmp.equals("{") || tmp.equals("(")|| tmp.equals("[")){
                stack.push(tmp);
            }else {
                if (stack.isEmpty()) return false;
                if (!tmp.equals(hashMap.get(stack.pop()))) return false;
            }
        }
        if (stack.isEmpty())return true;
        return false;
    }

    public static void main(String[] args) {
        String s="([)]";
        System.out.println(isValid(s));
    }
}
