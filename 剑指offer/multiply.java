package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/23 16:09
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class multiply {
    /**
     * 运行时间：12ms，占用内存9152k
     * 算法思路：就是B中的每一项只有对应的A项没有乘，那么不妨就直接将A按照第i项分为前后两段，然后使用left以及right两个数组，分别表示
     * 第i项的时候左半段的乘积，以及右半段的乘积，然后两个对应相乘就可以。
     * 参考链接：https://blog.csdn.net/lynn_baby/article/details/79729759
     * @param A
     * @return
     */
    public int[] multiply(int[] A){
        int[] left=new int[A.length];
        int[] right=new int[A.length];
        int[] B=new int[A.length];
        int n=A.length;
        left[0]=1;
        right[n-1]=1;
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*A[i-1];
            right[n-i-1]=right[n-i]*A[n-i];
        }
        for(int i=0;i<n;i++)
            B[i]=left[i]*right[i];
        return B;
    }
}
