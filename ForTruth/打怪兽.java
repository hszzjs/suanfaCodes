package com.company.ForTruth.Tencent;

import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/21 17:01
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * 小Q打算穿越怪兽谷，他不会打怪，但是他有钱。他知道，只要给怪兽一定的金币，怪兽就会一直护送着他出谷。
 在谷中，他会依次遇见N只怪兽，每只怪兽都有自己的武力值和要“贿赂”它所需的金币数。如果小Q没有“贿赂”某只怪兽，
 而这只怪兽“武力值”又大于护送他的怪兽武力之和，这只怪兽就会攻击他。小Q想知道，要想成功穿越怪兽谷而不被攻击，他最少要准备多少金币。
 输入格式
 第一行包含整数N，表示怪兽的数量。
 第二行包含N个整数d1,d2,…,dn，表示每只怪兽的武力值。
 第三行包含N个整数p1,p2,…,pn，表示收买N只怪兽所需的金币数。
 输出格式
 输出一个整数，表示所需最小金币数。
 数据范围
 1≤N≤50,
 1≤di≤10^12,
 1≤pi≤2
 输入样例1：
 3
 8 5 10
 1 1 2
 输出样例1：
 2
 输入样例2：
 4
 1 2 4 8
 1 2 1 2
 输出样例2：
 6
 */
public class 打怪兽 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] D=new int[N];
        int[] P=new int[N];
        for(int i=0;i<N;i++){
            D[i]=sc.nextInt();
        }
        for(int i=0;i<N;i++){
            P[i]=sc.nextInt();
        }
        int M=2*N;
        int[][] dp=new int[N][M];
        
    }
}
