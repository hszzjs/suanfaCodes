package com.company.nowLeetCode.Array;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2019/2/22 9:37
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_spiralOrder {
    /**
     * 这个题目的矩阵行数与列数是不等的，指针的使用很巧妙，使用xy作为移动指针自己计算，行数随着转圈-2
     * 列数随着转圈减二
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> spiralOrder(int[][] matrix){
        ArrayList<Integer> res=new ArrayList<>();
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return res;
        int m=matrix.length,n=matrix[0].length;
        int x=0,y=0;
        while (m>0 && n>0){
            if (m==1){
                for (int i=0;i<n;i++){
                    res.add(matrix[x][y++]);
                }
                break;
            }
            if (n==1){
                for (int i=0;i<m;i++){
                    res.add(matrix[x++][y]);
                }
                break;
            }
            for (int i=0;i<n-1;i++){
                res.add(matrix[x][y++]);
            }
            for (int i=0;i<m-1;i++){
                res.add(matrix[x++][y]);
            }
            for (int i=0;i<n-1;i++){
                res.add(matrix[x][y--]);
            }
            for (int i=0;i<m-1;i++){
                res.add(matrix[x--][y]);
            }
            x++;
            y++;
            m-=2;
            n-=2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] m=new int[][]{{1,2},{3,4},{5,6}};
//        {1,2,3},{4,5,6},{7,8,9}
//        {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
        ArrayList<Integer> res=spiralOrder(m);
        for (int i:res){
            System.out.print(i+"+");
        }
    }
}
