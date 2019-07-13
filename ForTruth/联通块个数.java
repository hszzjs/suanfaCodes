package com.company.ForTruth.zijietiaodong.夏令营笔试525;

import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/25 14:32
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * 输入一个只包含0和1的二维数组，上下左右对角相邻的1组成一个区块。0不形成区块，求数组中的区块个数。
 * 输入描述：
 * 第一行两个数表示行数与列数N和M，之后的N行分别代表数组的每一行。
 * 输出描述：对于每个数组输出一个整数表示区块个数
 */
public class 联通块个数 {
    public static void main(String[] args) {//80%
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(),M=sc.nextInt();
        int[][] arr=new int[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        boolean[][] visited=new boolean[N][M];//用于标志是否遍历过
        int res=0;
        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (!visited[i][j] && arr[i][j]==1){
                    res++;
                    bfs(arr,visited,i,j);//使用宽度优先搜索进行遍历
                }
            }
        }
        System.out.println(res);
    }
    private static void bfs(int[][] arr,boolean[][] visited,int row,int col){
        if(row>=0 && row<arr.length && col>=0 && col<arr[0].length && !visited[row][col] && arr[row][col]==1){
            visited[row][col]=true;
            bfs(arr,visited,row-1,col);//上
            bfs(arr,visited,row-1,col+1);//上右
            bfs(arr,visited,row,col+1);//右
            bfs(arr,visited,row+1,col+1);//下右
            bfs(arr,visited,row+1,col);//
            bfs(arr,visited,row+1,col-1);
            bfs(arr,visited,row,col-1);
            bfs(arr,visited,row-1,col-1);
        }
    }
}
