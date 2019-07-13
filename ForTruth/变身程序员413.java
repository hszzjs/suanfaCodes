package com.company.ForTruth.zijietiaodong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/7 16:32
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：将产品经理转换为程序员
 * 在给定的矩形网格中,每个单元格可以有以下三个值之一:
 * ·值0代表空单元格;
 * ·值1代表产品经理;
 * ·值2代表程序员;
 * 每分钟,任何与程序员(在4个正方向上)相邻的产品经理都会变成程序员。
 * 返回直到单元格中没有产品经理为止所必须经过的最小分钟数。如果不可能，返回-1.
 * 输入描述：
 * 不固定多行〈行数<= 10)，毎行是按照空格分割的数字(不固定，毎行数字个数<= 10)
 * 其中每个数组项的取值仅为0、1、2三种， (读取时可以按行读取，直到读取到空行为止，再对读取的所有行做转换处理)
 * 输出描述：
 * 如果能够将所有产品经理变成程序员，则输出最小的分钟数。
 * 如果不能够将所有的产品经理变成程序费，则返回-1.
 *
 * 示例：
 * 0 2
 * 1 0
 * 输出：-1
 * 1 2 1
 * 1 1 0
 * 0 1 1
 * 输出：3
 */

/**
 * 思路：与LeetCode上腐烂的橘子相同
 * 首先分析就是题目是从产品经理变为程序员，是一个蔓延的问题，仔细想它的蔓延时间必然是固定的最终，必竟每个程序员可以将
 * 产品经理变为程序员只能是一分钟上下左右，所以只需要标志当前程序员是第几分钟，那他的上下左右产品经理变身必然是它的+1分钟。
 * 所以使用的是BFS。获取数据部分就不说了，然后就是借用队列去处理，毕竟遵循的是先进先出这一理念，但是队列里面存什么呢，
 * 因为要上下左右走，所以需要索引，同时需要它变身的时间，所以创建一个新的数据结构。然后就是队列不为空的时候就一直变身循环，
 * 一旦为空，就意思能变身的都变身了。如果还有产品经理剩余就返回-1，否则返回分钟数。
 */
public class 变身程序员413 {
    static int[][] d={{-1,0},{1,0},{0,1},{0,-1}};
    public static class XY{
        int x,y,t;
        public XY(int x,int y,int t){
            this.x=x;
            this.y=y;
            this.t=t;
        }
    }
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next().trim().replaceAll(" ","");
            arr.add(str);
        }
        int m=arr.size(),n=arr.get(0).length();
        int num_c=0;
        int[][] map=new int[m][n];//所有数据
        Queue<XY> queue=new LinkedList<>();//初始将所有程序员放进去
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                map[i][j]=arr.get(i).charAt(j)-'0';
                if(map[i][j]==2){
                    queue.add(new XY(i,j,0));
                }
                if(map[i][j]==1) num_c++;//计数一共有多少个产品，为最终是否成功变身提供参考
            }
        }
        int res=0;
        while (!queue.isEmpty()){
            XY xy=queue.poll();
            for(int i=0;i<d.length;i++){
                int xd=xy.x+d[i][0],yd=xy.y+d[i][1];
                if(0<=xd && xd<m && 0<=yd && yd<n && map[xd][yd]==1){
                    map[xd][yd]=2;
                    num_c--;
                    queue.add(new XY(xd,yd,xy.t+1));
                    res=xy.t+1;
                }
            }
        }
        if(num_c==0) System.out.println(res);
        else System.out.println(-1);
    }
}
