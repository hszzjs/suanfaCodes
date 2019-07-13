package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/11/29 9:35
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 算法思路：这个就是依照上衣体，要么从第n个跳起，要么第n-1，要么第n-2，...，要么第0
 * 所以f(n-1)=f(n-2)+...++f(0)+1,f(n)=f(n-1)+...+f(0)+1=f(n-1)*2=2^(n-1)
 */
public class JumpFloorII {

    public static int JumpFloorII(int target){
        if(target<=0)
            return 0;
        return 1<<(target-1);
    }
    public static void main(String[] args){
        int n=6;
        System.out.println(JumpFloorII.JumpFloorII(n));
    }
}
