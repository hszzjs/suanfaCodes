package com.company.ForTruth.zijietiaodong;

import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/7 8:58
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：找零
 * 某国货币系统包含面值1元，4元，16元，64元共计4钟硬币，以及面值1024元的纸币。
 * 现在某人使用1024元的纸币购买了一件价格为N(0≤N≤1024)的商品。
 * 请问最少他会收到多少硬币?
 * 输入描述：一行，包含一个数N
 * 输出描述：一行，包含一个数，表示最少收到的硬币数
 * 举例：
 * 输入200，输出17（包含12个64元硬币，3个16元硬币，2个4元硬币）
 *
 * 思路：
 * 事实上，我感觉这道题就是在开玩笑，不是直接从最大到最小除取余，毕竟这个还是不用循环，
 * 所以也没有时间复杂度要咋
 */
public class 找硬币316 {
    /**
     * 这个与当时说参加过的代码相同，说是AC了，但是有的说是基于动态规划思想考虑，也可以。
     * 这里有一个是说除法使用移位会更快，所以右移一位>>1相当于除以2，右移n位>>n相当于除以2^n
     * @param args
     */
    public static void main0(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=1024-sc.nextInt();
        sc.close();
        int res=0;
        if(N>=64){
            res+=N/64;
            N=N%64;
        }
        if(N>=16){
            res+=N/16;
            N=N%16;
        }
        if(N>=4){
            res+=N/4;
            N=N%4;
        }
        if(N!=0) res+=N;
        System.out.println(res);
    }

    /**
     * 动态规划，要求的结果是F(n)，n为需要找零的钱，如果要F(n)最小，那么最优子结构就是：
     * F(n)=min{F(n-1)，F(n-4)，F(n-16)，F(n-16)}+1，以此递推到边界为1或2或3或4的时候可以得到边界条件，
     * 然后将递推反过来叠加求解，可以声明一个数组为N+1（数组下标从0开始，将下标和金额对应），写入初始条件，
     * 以此往上叠加求解，就可以得到结果。
     * 基于此知道，动态规划的三个条件：最优子结构，转移方程，边界条件
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=1024-sc.nextInt();
        sc.close();
        int[] res=new int[N+1];
        if(N<4){
            for(int i=0;i<=N;i++) res[i]=i;
            System.out.println(res[N]);
            return;
        }
        for(int i=0;i<4;i++) res[i]=i;
        for(int i=4;i<=N;i++){
            int min=Math.min(res[i-1],res[i-4]);
            if(i>16) min=Math.min(min,res[i-16]);
            if(i>64) min=Math.min(min,res[i-64]);
            res[i]=min+1;
        }
        System.out.println(res[N]);
    }
}
