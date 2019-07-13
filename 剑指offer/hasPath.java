package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/26 20:30
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：矩阵中的路径:判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 */
public class hasPath {
    /**
     * 运行时间：22ms，占用内存：9392k
     * 参考链接：https://blog.csdn.net/github_39248264/article/details/82555859?utm_source=blogxgwz9
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        //如果矩阵、字符串为空或长度为0，返回false
        if (matrix==null||str==null||matrix.length==0||str.length==0) return false;
        int len=matrix.length;
        //定义一个boolean数组、判断当前字符是否被访问过
        boolean[] flags=new boolean[len];
        //如果能够在矩阵中找到一个字符与字符串第一个字符相等，则返回true
        for(int r=0;r<rows;++r){
            for (int c=0;c<cols;++c){
                if (matrix[r*cols+c]==str[0]){
                    if (hasPath(matrix,rows,cols,r,c,str,0,flags)) return true;
                }
            }
        }
        return false;
    }
    //判断路径中是否存在下一个字符
    private boolean hasPath(char[] matrix,int rows,int cols,int r,int c,char[] str,int index,boolean[] flags){
        //定义一个索引从0开始到等于字符串长度结束
        if (index==str.length) return true;
        //如果行列超出矩阵范围，返回false
        if (r>=rows||r<0||c>=cols||c<0) return false;
        //如果当前字符被访问过，或矩阵元素不等于字符串当前元素，则返回false
        if (flags[r*cols+c]==true||matrix[r*cols+c]!=str[index]) return false;
        flags[r*cols+c]=true;
        //是否存在一条包含某字符串所有字符的路径=向上查找||向下查找||向右查找||向左查找
        boolean hp=hasPath(matrix,rows,cols,r+1,c,str,index+1,flags)||
                hasPath(matrix,rows,cols,r-1,c,str,index+1,flags)||
                hasPath(matrix,rows,cols,r,c-1,str,index+1,flags)||
                hasPath(matrix,rows,cols,r,c-1,str,index+1,flags);
        if (hp==true) return true;
        flags[r*cols+c]=false;
        return false;
    }
}
