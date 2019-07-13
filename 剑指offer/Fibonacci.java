package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/11/28 22:35
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * 算法思路：分两种实现方法，一种递归一种非递归，明显可以看到非递归的时间复杂度远低于递归算法，
 * 并且在空间复杂度上是相同的。
 */
public class Fibonacci {

    /**
     * 递归算法实现==》运行时间：1282ms，占用内存：9316k
     * @param n
     * @return
     */
    public int Fibonacci(int n){
        if (n==0) return 0;
        else if (n==1) return 1;
        else
            return Fibonacci(n-1)+Fibonacci(n-2);
    }

    /**
     * 非递归算法实现==》运行时间：19ms，占用内存：9312k
     * @param n
     * @return
     */
    /**
    public int Fibonacci(int n){
        int temp=1;
        int result=0;
        int temp2=1;
        if(n==0){
            return 0;
        }
        if (n==1 || n==2){
            return 1;
        }
        for (int i=3;i<=n;i++){
            result=temp+temp2;
            temp=temp2;
            temp2=result;
        }
        return result;
    }
    */

    /**
     * 另一种非递归的方法实现==》运行时间：16ms，占用内存：9216k,事实并没有多大区别
     * @param n
     * @return
     */
    /**
    public int Fibonacci(int n){
        int[] result = { 0, 1 };
        if (n < 2)
            return result[n];
        int fiboOne = 1;
        int fiboTwo = 0;
        int fn = 0;
        for (int i = 2; i <=n; i++) {
            fn = fiboOne + fiboTwo;
            fiboTwo = fiboOne;
            fiboOne = fn;
        }
        return fn;
    }
     */
}
