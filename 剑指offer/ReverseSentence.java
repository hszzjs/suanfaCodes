package com.company.offer;

import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2018/12/19 10:47
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class ReverseSentence {
    /**
     * 运行时间19ms，占用内存9616k
     * 自己搞的，就是使用了栈的特点
     * @param str
     * @return
     */
    public static String ReverseSentence(String str){
        StringBuilder sbtmp=new StringBuilder();
        Stack<String> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' ') sbtmp.append(str.substring(i,i+1));
            else{
                stack.push(sbtmp.toString());
                System.out.println(sbtmp.toString()+"huihi");
                sbtmp=new StringBuilder();
            }
        }
        stack.push(sbtmp.toString());
        System.out.println(sbtmp.toString()+"huihi");
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            System.out.println(stack.peek()+"===");
            sb.append(stack.pop()+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static void main(String[] args){
        String str="I am a student.";
        System.out.println(ReverseSentence(str));
    }
}
