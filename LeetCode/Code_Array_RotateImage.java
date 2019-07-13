package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 22:04
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_RotateImage {
    /**
     * 顺时针90度，首先画图直到是元素的所在列变为之后的所在行数，而所在行数，变为逆序数的列数，
     * 在原数组上操作，就只需要操作四分之一旋转就可以
     * @param matrix
     */
    public void rotate(int[][] matrix){
        int n=matrix.length;
        for (int i=0;i<n/2;i++){
            for (int j=0;j< Math.ceil(((double) n) / 2.);j++){//这个是想正无穷方向取整
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }
    }
}
