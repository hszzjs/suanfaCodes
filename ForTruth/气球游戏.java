package com.company.ForTruth.Tencent;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/16 21:02
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 小Q在进行射击气球的游戏，如果小Q在连续T枪中打爆了所有颜色的气球，将得到一只QQ公仔作为奖励。（每种颜色的球至少被打爆一只）。
 这个游戏中有m种不同颜色的气球，编号1到m。小Q一共有n发子弹，然后连续开了n枪。小Q想知道在这n枪中，打爆所有颜色的气球最少用了连续几枪？
 输入格式
 第一行包含两个整数n和m。
 第二行包含n个整数，分别表示每一枪打中的气球的颜色，0表示没打中任何颜色的气球。
 输出格式
 一个整数表示小Q打爆所有颜色气球用的最少枪数。如果小Q无法在这n枪打爆所有颜色的气球，则输出-1。
 数据范围
 1≤n≤10^6,1≤m≤2000
 输入样例：
 12 5
 2 5 3 1 3 2 4 1 0 5 4 3
 输出样例：
 6
 样例解释
 有五种颜色的气球，编号1到5。
 游客从第二枪开始直到第七枪，这连续六枪打爆了5 3 1 3 2 4这几种颜色的气球，包含了从1到5的所有颜色，所以最少枪数为6。
 */
public class 气球游戏 {
    /**
     * 暴力超时，然后就是改进喽
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[] colors=new int[n];
        for (int i=0;i<n;i++)
            colors[i]=sc.nextInt();
        HashSet<Integer> set=new HashSet<>();
        int res=Integer.MAX_VALUE;
        boolean T=false;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(colors[j]==0) continue;
                if(!set.contains(colors[j])) set.add(colors[j]);
                if(set.size()==m) {
//                    System.out.println(i+"**"+j);
                    res=Math.min(res,j-i+1);
                    T=true;
                    break;
                }
            }
            set=new HashSet<>();
        }
        System.out.println(T?res:-1);
    }

    /**
     * 使用滑动窗口求解
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[] colors=new int[n];
        for (int i=0;i<n;i++) {
            colors[i]=sc.nextInt();
        }
        int res=minWindow(colors,m);
        System.out.println(res);
    }
    private static int minWindow(int[] nums,int m){
        int cnt=m;//判断是否包含所有颜色
        int[] dict=new int[m+1];//记录颜色出现的次数
        for (int i=1;i<=m;i++){
            dict[i]++;//dict为1表示出现过一次，
        }
        int begin=0,end=0;
        int width=Integer.MAX_VALUE;
        while (end<nums.length){
            int endNum=nums[end++];
            if (dict[endNum]-->0)
                System.out.println(endNum);
                cnt--;
            while (cnt==0){
                if (end-begin<width)
                    width=end-begin;
                int beginNum=nums[begin++];
                if (dict[beginNum]++==0)//表示颜色beginnum没有出现，在窗体内
                    cnt++;
            }
        }
        return width==Integer.MAX_VALUE?-1:width;
    }
}
