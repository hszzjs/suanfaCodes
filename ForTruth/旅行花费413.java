package com.company.ForTruth.zijietiaodong;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/9 11:53
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * 小明目前在做一份毕业旅行的规划,打算从北京出发,分别去若干个城市,然后再回到北京,每个城市之间均乘坐高铁,且每个城市只去一次,
 * 由于经费有限,希望能够通过合理的路线安排尽可能的省一些路上的花销。给定一组城市和每对城市之间的火车票的价钱,
 * 找到每个城市只访问一次并返回起点的最小车费花销
 * 输入描述：
 * 城市个数n(1<n<=20包括北京)
 * 城市间的车票价钱 n行n列的矩阵
 * 输出描述：
 * 最小车费花销 s
 * 示例：
 * 输入：
 * 4
 * 0 2 6 5
 * 2 0 4 4
 * 6 4 0 2
 * 5 4 2 0
 * 输出：13
 */
public class 旅行花费413 {
    /**
     * 自己想的，使用的是递归的方法，递归使人窒息毕竟超时了，所以从递归里面抽象出来动态规划
     * 才可能行。然而并没有找到合适这道题的答案。
     * 但是除了超时，这个递归的方法也是对的，基本上小的例子都能过。有一个20个城市的例子就过不了。
     */
    public static int res=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[][] map=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j]=sc.nextInt();
            }
        }
        int cost=0;
        HashSet<Integer> set=new HashSet<>();
        go(map,cost,set,0);//递归从北京出发
        System.out.println(res);
    }

    private static void go(int[][] map,int cost,HashSet<Integer> set,int index){
        if(set.size()==map.length-1) {
            res=Math.min(cost+map[index][0],res);//最后是要回到北京
            return;
        }
        for(int i=1;i<map.length;i++){//除北京外的所有城市遍历
            if(i!=index && !set.contains(i)) {
                set.add(i);
                if(res>cost+map[index][i]) go(map,cost+map[index][i],set,i);
                set.remove(i);
            }
        }
    }
    /**
     * 所以该怎么求解呢，我们很容易想到一种类似于穷举的思路：现在假设我们要拜访11个城市，从城市1出发，最后回到城市1。
     * 显然，从城市1出来后，我们随即可以选择剩余的10个城市之一进行拜访（这里所有城市都是连通的，总是可达的，
     * 而不连通的情况属于个人特殊业务的装饰处理，不是本文考虑范畴），那么很显然这里就有10种选择，以此类推，
     * 下一次就有9种选择…总的可选路线数就是：10!。也就是说需要用for循环迭代10!次，才能找出所有的路线，
     * 进而筛选出最短的那条来。如果只拜访个10个城市或许还好的话（需要迭代3628800次），
     * 那要拜访100个城市（需要迭代9.3326215443944 * 10^157）简直就是计算机的噩梦！更多个城市的话，计算的时间开销可想而知！
     * 更一般地，如果要拜访n+1个城市，总的可选路线数就是n!，进而时间复杂度就是O(n!)，从这里我们同理也可以看出，
     * 这个算法的时间复杂度是非多项式的，它的开销大是显而易见的。所以问题的关键不在于寻找两两城市间的最短路径，
     * 而在于去寻找一那条最短的巡回路径，换句话说，就是寻找一组拜访城市的先后次序序列 n1n2n3…nini+1…nnn1。
     */

}
