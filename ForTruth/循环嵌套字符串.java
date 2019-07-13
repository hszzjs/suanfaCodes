package com.company.ForTruth.zijietiaodong.夏令营笔试525;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2019/5/25 14:38
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * %#之间是需要循环的字符，数字表示循环次数，示例如下：
 * 输入：3%acm#2%acm#
 * 输出：acmacmacmacmacm
 */
public class 循环嵌套字符串 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine().trim();
        char[] chars=str.toCharArray();
        Stack<Character> stack=new Stack<>();
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<chars.length;i++){
            if(chars[i]>='0' && chars[i]<='9') stack.push(chars[i]);
            else if (chars[i]=='%') stack.push(chars[i]);
            else if (chars[i]!='#') stack.push(chars[i]);
            else {
                StringBuffer temp= new StringBuffer();
                while (stack.peek()!='%'){
                    temp.insert(0,stack.pop());
                }
                stack.pop();
                int num=stack.pop()-'0';
                StringBuffer tmpp=new StringBuffer();
                for (int j=0;j<num;j++){
                    tmpp.append(temp.toString());
                }
                for (int j=0;j<tmpp.length();j++){
                    stack.push(tmpp.toString().toCharArray()[j]);
                }
            }
        }
        while (!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        System.out.println(sb.toString());
    }
}
