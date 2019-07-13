package com.company.ForTruth.zijietiaodong;

import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/9 11:16
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * 机器人正在玩一个古老的基于DOS的游戏。游戏中有N+1座建筑——从0到N编号,从左到排列。
 * 编号为0的建筑高度为0个单位,编号为i的建筑的高度为H(i)个单位。起初,机器人在编号为0的建筑处。每一步,它跳到下一个(右边)建筑。
 * 假设机器人在第k个建筑,且它现在的能量值是E,下一步它将跳到第个k+1建筑。它将会得到或者失去正比于与H(k+1) 与E之差的能量。
 * 如果H(k+1)> E那么机器人就失去H(k+1)-E的能量值,否则它将得到E-H(k+1)的能量值。
 * 游戏目标是到达第个N建筑,在这个过程中,能量值不能为负数个单位。现在的问题是机器人以多少能量值开始游戏,才可以保证成功完成游戏?
 * 输入描述：
 * 第一行输入,表示一共有N组数据.第二个是N个空格分隔的整数, H1, H2, H3, ..., Hn代表建筑物的高度
 * 输出描述：
 * 输出一个单独的数表示完成游戏所需的最少单位的初始能量
 * 示例：
 * 输入：
 * 5
 * 3 4 3 2 4
 * 输出：4
 * 输入：
 * 3
 * 4 4 4
 * 输出：
 * 4
 * 思路：
 * 这道题事实上和剪绳子一样，假若你想的是最小能量那就是最后为0，但是由于塔高低问题，需要一致判断高低，
 * 就不妨使用二分法来探究，就是试探，根据条件判断有效性就可以。
 * 但是bug的一点就是，根据大家所说，即使是二分法，有的A了，有的只是8%左右。但是二分法依旧有效。
 */
public class 机器人越塔413 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int max=Integer.MAX_VALUE;
        int min=0,res=Integer.MAX_VALUE;
        while (min<=max){
            int mid=(min+max)/2;
            if(isValid(arr,mid)) {
                max=mid-1;
                res=Math.min(res,mid);
            }
            else min=mid+1;
        }
        System.out.println(res);
    }
    private static boolean isValid(int[] arr,int energy){
        for(int i=0;i<arr.length;i++){
            if(energy>arr[i]) energy+=(energy-arr[i]);
            else energy-=(arr[i]-energy);
        }
        return energy>=0;
    }
}
