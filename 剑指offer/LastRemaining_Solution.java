package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/20 12:57
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：孩子们的游戏
 * 参考链接：https://blog.csdn.net/lynn_baby/article/details/79723736
 */
public class LastRemaining_Solution {
    /**
     * 运行时间：17ms，占用内存：9256k
     * 算法思路：这里涉及约瑟夫环问题，使用公式。
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n,int m){
        if (n<=0) return -1;
        int res=0;
        for(int i=2;i<=n;i++){
            res=(res+m)%i;
        }
        return res;
    }
}
