package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/26 21:04
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：机器人的运动范围
 */
public class movingCount {
    /**
     * 运行时间：19ms，占用内存：9300k
     * 参考链接：https://blog.csdn.net/sniperken/article/details/53964663
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols){
        boolean[] flag=new boolean[rows*cols];
        return movingCount(threshold,rows,cols,0,0,flag);
    }
    private int movingCount(int threshold,int rows,int cols,int i,int j,boolean[] flag){
        int index=i*cols+j;
        if (i<0||i>=rows||j<0||j>=cols||flag[index]||(sum(i)+sum(j))>threshold) return 0;
        flag[index]=true;
        return 1+movingCount(threshold,rows,cols,i+1,j,flag)+movingCount(threshold,rows,cols,i,j+1,flag);
    }
    public int sum(int num){
        if (num<=0) return 0;
        int sum=0;
        while (num!=0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
}
