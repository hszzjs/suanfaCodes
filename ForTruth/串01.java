package com.company.ForTruth.Tencent;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2019/5/16 20:40
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 给定一个仅包含0或1的字符串，现在可以对其进行一种操作：当有两个相邻的字符其中有一个是0另外一个是1的时候，可以消除掉这两个字符。
 这样的操作可以一直进行下去直到找不到相邻的0和1为止。问这个字符串经历了操作以后的最短长度。
 输入格式
 第一行包含一个整数 n，表示字符串的初始长度。
 第二行为所给字符串。
 输出格式
 输出共一行，包含一个整数，表示问题的解。
 数据范围
 1≤n≤2∗105
 输入样例1：
 4
 1100
 输出样例1：
 0
 输入样例2：
 5
 01010
 输出样例2：
 1
 */
public class 串01 {
    /**
     * 两个思路：一个是使用栈，一个是直接只要01个数相同那必然就消完了
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        char[] chars=sc.nextLine().trim().toCharArray();
        Stack<Character> stack=new Stack<>();
        stack.push(chars[0]);
        for(int i=1;i<n;i++){
            while (!stack.isEmpty()&& i<n && chars[i]!=stack.peek()){
                stack.pop();
                i++;
            }
            if (i<n) stack.push(chars[i]);
        }
        System.out.println(stack.isEmpty()?0:stack.size());
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        char[] chars=sc.nextLine().trim().toCharArray();
        int zero=0,one=0;
        for (int i=0;i<n;i++){
            if (chars[i]=='0') zero++;
            else one++;
        }
        System.out.println(Math.abs(zero-one));
    }
}
