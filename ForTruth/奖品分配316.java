package com.company.ForTruth.zijietiaodong;

import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/7 12:00
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * 有n个人参加编程比赛，比赛结束后每个人都得到一个分数；现在所有人排成一圈（第一个和第n个相邻）领取奖品，要求：
 * 1. 如果某个人的分数比左右的人高，那么奖品数量也要比左右的人多；
 * 2. 每个人至少得到一个奖品；问最少应该准备多少个奖品。
 * 输入描述：
 * 第一行是整数n，表示测试样例个数
 * 每个测试样例的第一行是一个整数n，表示参加比赛的人数；（0<n<100000）
 * 第二行是n个正整数a[i] (0<a[i]<100000)，表示的从第1个人到第n个的分数；
 * 输出描述：
 * 对每个测试样例，输出应该准备的最少奖品。
 *
 * 示例：
 * 2
 * 2
 * 1 2
 * 4
 * 1 2 3 3
 * 输出：
 * 3
 * 8
 */
public class 奖品分配316 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        for(int i=0;i<num;i++){
            int n=sc.nextInt();
            int[] scores=new int[n];
            for (int j=0;j<n;j++) {
                scores[j]=sc.nextInt();
//                System.out.println(scores[j]);
            }
            System.out.println(process(n,scores));
        }
    }

    /**
     * 这个题真的心累，毕竟只有理清了它的逻辑关系再下手才会好一点。做法网上挺多的，下面这个是参考了别人的，
     * 然后加了点自己的想法做的。是唯一一个让人觉得有思路。
     * 思路：
     * 这种题要不断更新找最小值，所以就必然是想到深/宽度优先搜索，但是该怎么搞呢？就是环已经固定了，那么接下来，
     * 就是最小，那必然换里面某个人的分数同时小于等于两边的分数，那他必然是只有一个奖品，因为它只需要满足有奖品即可，不需要
     * 比别人多。然后就是那些至少比两边其中一个人分高，是不确定的，那就需要使用深度优先搜索了。
     * 但是这个该怎么搞呢，那必然是依旧需要与它的前后相比，先与前面的相比，它是前面分高的，但是前面那人也没有定下来奖品数，
     * 那就前面这个人遍历。同理与后面的那个人也要进行比较，终于遍历到旁边有奖品数的人，那就进行更新，更新的时候需要比已经有的奖品数
     * 大，所以要取下最大值。
     * @param n
     * @param scores
     * @return
     */
    private static int process(int n,int[] scores){
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int pre,post;
            if(i==0) pre=n-1;
            else pre=i-1;
            if(i==n-1) post=0;
            else post=i+1;
            if(scores[i]<=scores[pre] && scores[i]<=scores[post]) {
                res[i]=1;
            }
        }
        int min=0;
        for(int i=0;i<n;i++){
            if(res[i]==0){
                dfs(scores,res,i,n);
            }
            min+=res[i];
        }
        return min;
    }

    private static void dfs(int[] scores,int[] res,int m,int n){
        int pre,post;
        if(m==0) pre=n-1;
        else pre=m-1;
        if(m==n-1) post=0;
        else post=m+1;
        if(scores[pre]<scores[m] && res[pre]==0){
            dfs(scores,res,pre,n);
        }
        if(scores[post]<scores[m] && res[post]==0){
            dfs(scores,res,post,n);
        }
        if(scores[pre]<scores[m]) res[m]=Math.max(res[m],res[pre]+1);
        if(scores[post]<scores[m]) res[m]=Math.max(res[m],res[post]+1);
    }
    /**
     * 接下来是分糖果问题，LeetCode中的原题，如下：
     * There are N children standing in a line. Each child is assigned a rating value.
     You are giving candies to these children subjected to the following requirements:
     * Each child must have at least one candy.
     * Children with a higher rating get more candies than their neighbors.
     What is the minimum candies you must give?
     */
    public int candy(int[] ratings){
        if(ratings==null || ratings.length==0) return 0;
        int[] leftnums=new int[ratings.length];
        int[] rightnums=new int[ratings.length];

        leftnums[0]=1;
        for (int i=1;i<ratings.length;i++){
            if (ratings[i]>ratings[i-1])
                leftnums[i]=leftnums[i-1]+1;
            else leftnums[i]=1;
        }

        rightnums[ratings.length-1]=leftnums[ratings.length-1];
        for (int i=ratings.length-2;i>=0;i--){
            if (ratings[i]>ratings[i+1])
                rightnums[i]=rightnums[i+1]+1;
            else rightnums[i]=1;
        }
        int res=0;
        for (int i=0;i<ratings.length;i++){
            res+=Math.max(leftnums[i],rightnums[i]);
        }
        return res;
    }

}
