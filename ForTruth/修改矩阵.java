package com.company.ForTruth.美团;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/12 10:05
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 我们称一个矩阵为黑白矩阵，当且仅当对于该矩阵中每一个位置如(i, j)，其上下左右四个方向的数字相等，即(i-1, j)、(i+1, j)、
 * (i, j-1)、(i, j+1)四个位置上的数字两两相等且均不等于(i, j)位置上的数字。（超出边界的格子忽略）
 * 现在给出一个 n*m 的矩阵，我们想通过修改其中的某些数字，使得该矩阵变成黑白矩阵，请问最少需要修改多少个数字。
 输入格式
 第一行包含两个整数n和m，表示矩阵的长宽。
 接下来n行，每行包含m个整数，用来表示整个矩阵。
 输出格式
 仅包含一个整数，表示原矩阵变为黑白矩阵最少修改的数字数量。
 数据范围
 1≤n,m≤10^5,
 1≤n∗m≤10^5
 输入样例1：
 3 3
 1 1 1
 1 1 1
 1 1 1
 输出样例1：
 4
 输入样例2：
 3 3
 1 1 1
 1 5 1
 1 1 1
 输出样例2：
 4
 */
public class 修改矩阵 {
    static int[][] d={{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[][] arr=new int[n][m];
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
                if((i+j)%2==0) {
                    if(!map1.containsKey(arr[i][j])) map1.put(arr[i][j],1);
                    else map1.put(arr[i][j],map1.get(arr[i][j])+1);
                }else {
                    if(!map2.containsKey(arr[i][j])) map2.put(arr[i][j],1);
                    else map2.put(arr[i][j],map2.get(arr[i][j])+1);
                }
            }
        }
        int res=Integer.MAX_VALUE;
        int t1=m*n-(m*n)/2,t2=(m*n)/2;
        for(int tmp1:map1.keySet()){
            for(int tmp2:map2.keySet()){
                if(tmp1!=tmp2){
                    res=Math.min(res,t1-map1.get(tmp1)+t2-map2.get(tmp2));
                }
            }
        }
        if(map1.size()==1 && map2.size()==1) {
            for (int tmp1:map1.keySet()){
                for (int tmp2:map2.keySet()){
                    if(tmp1==tmp2) {
                        res=Math.min(t1,t2);
                    }
                }
            }
        }
        System.out.println(res);
        ArrayList<Integer> list=new ArrayList<>();
    }
}
