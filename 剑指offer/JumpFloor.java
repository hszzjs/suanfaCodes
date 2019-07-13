package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/11/29 8:50
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * 算法思路：
 * 感觉关键是理解跳台阶是什么情况，递归还可以理解，非递归完全不太明白
 * 就是这样去理解的，对于第n个台阶来说，只能从n-1或者n-2的台阶跳上去，所以F(n)=F(n-1)+F(n-2)
 */
public class JumpFloor {
    /**
     * 递归方式，接下来跳几个台阶，就两种，接下来跳一个那就剩target-1，两个就是target-2==》运行时间501ms，占用内存9360k
     * @param target
     * @return
     */
    public int JumpFloor(int target){
        if (target==1) return 1;
        if (target==2) return 2;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    /**
     * 非递归方法==》运行时间23ms，占用内存9112k
     * @param target
     * @return
     */
    /**
    public int JumpFloor(int target){
        if (target==0||target==1||target==2) return target;
        int first=1;
        int second=2;
        int res=0;
        for(int i=3;i<=target;i++){
            res=first+second;
            first=second;
            second=res;
        }
        return res;
    }
     */
}
