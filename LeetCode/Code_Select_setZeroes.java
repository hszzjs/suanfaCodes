package com.company.nowLeetCode.Select;

import java.util.HashSet;

/**
 * Author:   hszzjs
 * Date:     2019/2/20 20:01
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_setZeroes {
    /**
     * 这个是最简单的做法，将要置零的行号与列好记录下来，然后统一置零。
     * 不使用HashSet记录也可以使用数组进行记录
     * @param matrix
     */
    public static void setZeroes(int[][] matrix){
        if (matrix==null || (matrix.length==0 && matrix[0].length==0)) return;
        HashSet<Integer> rows=new HashSet<>();
        HashSet<Integer> cols=new HashSet<>();
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    if (!rows.contains(i)) rows.add(i);
                    if (!cols.contains(j)) cols.add(j);
                }
            }
        }
        for (int i:rows){
            for (int j=0;j<matrix[0].length;j++){
                matrix[i][j]=0;
            }
        }
        for (int j:cols){
            for (int i=0;i<matrix.length;i++){
                matrix[i][j]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix=new int[][]{{0,2,0,3},{4,5,6,7},{7,8,9,8},{6,5,4,0}};
        setZeroes(matrix);
        for (int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(matrix);
    }
}
