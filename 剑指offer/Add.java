package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/21 20:40
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 参考链接：https://blog.csdn.net/qqxx6661/article/details/82683614
 */
public class Add {
    /**
     * 运行时间：19ms，占用内存：9304k
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2){
        while (num2!=0){
            int temp=num1^num2;
            num2=(num1&num2)<<1;
            num1=temp;
        }
        return num1;
    }
}
