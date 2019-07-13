package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 21:34
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_searchMatrix {
    public boolean searchMatrix(int[][] matrix,int target){
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int row=0,col=matrix[0].length-1;
        while (row<matrix.length && col>=0){
            if (target<matrix[row][col]) col-=1;
            else if (target>matrix[row][col]) row+=1;
            else return true;
        }
        return false;
    }
}
