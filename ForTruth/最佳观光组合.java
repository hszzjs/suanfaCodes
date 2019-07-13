package com.company.ForTruth.zijietiaodong.夏令营笔试525;

import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/25 14:13
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 返回一对观光景点能取得的最高分。
 示例：
 输入：[8,1,5,2,6]
 输出：11
 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 提示：
 2 <= A.length <= 50000
 1 <= A[i] <= 1000
 */
public class 最佳观光组合 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] A=new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int res=0,cur=0;
        for (int a:A){
            res=Math.max(res,cur+a);
            cur=Math.max(cur,a)-1;//减1的目的就是，只要前进就进行减1，进而抵消的它的评分
        }
        System.out.println(res);
    }
}
