package com.company.offer;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2018/12/3 12:52
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 算法思路：看每一圈打印的时候四个顶点的规律，注意第一行的索引
 * 参考链接：https://blog.csdn.net/u013132035/article/details/80594659
 */
public class printMatrix {
    /**
     * 运行时间：31ms，占用内存：9512k
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> out=new ArrayList<>();
        int rows=matrix.length;
        int cols=matrix[0].length;
        if(matrix==null|| rows==0||cols==0) return out;
        int start=0;
        while(cols>start*2 && rows>start*2){
            MartixCircle(out,matrix,cols,rows,start);
            ++start;
        }
        return out;
    }

    private void MartixCircle(ArrayList<Integer> list,int[][] nums,int cols,int rows,int start){
        int endX=cols-1-start;
        int endY=rows-1-start;
        for(int i=start;i<=endX;++i){
            list.add(nums[start][i]);
        }
        if(start<endY){
            for (int i=start+1;i<=endY;++i){
                list.add(nums[i][endX]);
            }
        }
        if(start<endX && start<endY){
            for(int i=endX-1;i>=start;--i)
                list.add(nums[endY][i]);
        }
        if(start<endX&&start<endY-1){
            for (int i=endY-1;i>=start+1;--i)
                list.add(nums[i][start]);
        }
    }

    public ArrayList<Integer> printMatrix1(int [][] matrix) {
        ArrayList<Integer> res=new ArrayList<>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return res;
        int m=matrix.length,n=matrix[0].length;
        int x=0,y=0;
        while(m>0 && n>0){
            if(m==1){
                for(int i=0;i<n;i++){
                    res.add(matrix[x][y++]);
                }
                break;
            }
            if(n==1){
                for(int i=0;i<m;i++){
                    res.add(matrix[x++][y]);
                }
                break;
            }
            for(int i=0;i<n-1;i++){
                res.add(matrix[x][y++]);
            }
            for(int i=0;i<m-1;i++){
                res.add(matrix[x++][y]);
            }
            for(int i=n-1;i>0;i--){
                res.add(matrix[x][y--]);
            }
            for(int i=m-1;i>0;i--){
                res.add(matrix[x--][y]);
            }
            x++;
            y++;
            m-=2;
            n-=2;
        }
        return res;
    }
}
