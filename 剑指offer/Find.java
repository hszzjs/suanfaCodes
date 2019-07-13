package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/11/14 21:44
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 参考链接：https://blog.csdn.net/w13261711130/article/details/79974086
 */
public class Find {
    public static boolean Find(int target, int[][] array) {
        int m=array.length;
        if(m==0 || array[0].length==0) return false;//这里是为了避免是空的二维数组，但是是[[]]这样的。
        if(target>array[m-1][m-1]||target<array[0][0]) return false;
        int row=0;
        int col=m-1;//这里是选取右上角的数字进行比较，然后一列一列一行一行的去除
        while (row<m&&col>=0){
            if (array[row][col]==target) return true;
            if (array[row][col]>target) --col;
            else ++row;
        }
        return false;
    }
    public static void main(String[] args){
        int tar=16;
        int[][] arr=new int[][]{{}};
        System.out.println(arr);
        System.out.println(Find(tar,arr));
    }
}
