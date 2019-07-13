package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/11/29 10:24
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 算法思路：
 * 把整数减一和原来的数做与运算，会把该整数二进制表示中的最低位的1变成0,与运算进行多少次就有多少个1
 */
public class NumberOf1 {

    /**
     * 运行时间18ms，占用内存9520k
     * @param n
     * @return
     */
    public int NumberOf1(int n){
        int count=0;
        while (n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
