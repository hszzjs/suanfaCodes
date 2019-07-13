package com.company.CheekBrings;

import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/15 20:49
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：丢棋子问题
 * 一座大楼有0-N层,地面算作第0层,最高的一层为第N层。已知棋子从第0层掉落 ,肯定不会摔碎,从第i层掉落可能会捧碎,
 * 也可能不会摔碎(1<=i<=N)。给定整数N作为楼层数，再给定整数K作为棋子数，返回如果想找到棋子不会摔碎的最高楼层数，即使在最差的情况下
 * 扔的最少次数，一次只能扔一个棋子。
 * 举例：N=10，K=1，返回10
 */
public class 丢棋子问题{
    public static int solution1(int nLevel,int kChess){
        if(nLevel<1 || kChess<1) return 0;
        return Process1(nLevel,kChess);
    }

    private static int Process1(int nLevel,int kChess){
        if (nLevel==0) return 0;
        if (kChess==1) return nLevel;
        int min=Integer.MAX_VALUE;
        for (int i=1;i!=nLevel+1;i++){
            if (i==nLevel){
            }
            min=Math.min(min,Math.max(Process1(i-1,kChess-1),Process1(nLevel-1,kChess)));
        }
        return min+1;
    }

    public static int solution2(int nLevel,int kChess){
        if (nLevel<1||kChess<1) return 0;
        if (kChess==1) return nLevel;
        int[][] dp=new int[nLevel+1][kChess+1];
        for (int i=1;i!=dp.length;i++){
            dp[i][1]=i;
        }
        for (int i=1;i!=dp.length;i++){
            for (int j=2;j!=dp[0].length;j++){
                int min=Integer.MAX_VALUE;
                for (int k=1;k!=i+1;k++){
                    min=Math.min(min,Math.max(dp[k-1][j-1],dp[i-k][j]));
                }
                dp[i][j]=min+1;
            }
        }
        return dp[nLevel][kChess];
    }

    public static void main(String[] args) {
        System.out.println(solution2(105,2));
    }
}