package com.company.ForTruth.美团;

import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/14 19:41
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * 小王是一个喜欢健身的人，他每天都会围着一个 n*n 的场地外侧跑步。他是一个有强迫症的人，每跑 n+1 个单位长度，
 * 他就要在地上做一个标记。当他在一个点重复标记的时候，他就会结束当天的锻炼。显然当 n 一定时，他每天打标记的数量也是一定的。
 请你计算出来他每天要打多少个标记（最后一次重复标记也要计数）。
 输入格式
 第一行包含一个正整数 t，表示询问的数量。
 第二行包含 t 个整数，中间用空格隔开，每个整数表示一个询问所给出的 n。
 输出格式
 输出共 t 行。
 每行包含一个正整数，其中第 i 行的整数表示第 i 个询问的答案。
 数据范围
 1≤t≤10000,
 1≤n≤1000
 输入样例：
 2
 4 8
 输出样例：
 17
 33
 样例解释
 对于 4*4 的场地而言，其边界上的16个点都会被标记，因为起点会被标记两次，所以共17次。
 */
public class 爱健身的小王 {
    /**
     * 这个做法是请恕我脑子有坑去暴力做，遍历虽然AC
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            boolean[] res=new boolean[4*n];
            int m=0,cnt=0;
            while (res[m+n+1]!=true){
                m=m+n+1;
                res[m]=true;
                cnt+=1;
                if(m+n+1>4*n-1){
                    m-=(4*n);
                }
            }
            System.out.println(cnt+1);
        }
    }

    private static int gcd(int x,int y){
        return y==0?x:gcd(y,x%y);
    }
    /**
     * 这个是最小公约数的，时间上是比暴力短的
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++) {
            int n = sc.nextInt();
            int d=gcd(4*n,n+1);
            int res=4*n/d+1;
            System.out.println(res);
        }
    }
}
