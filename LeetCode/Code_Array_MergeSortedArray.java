package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 20:03
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_MergeSortedArray {
    /**
     * 这个东西的意思就是数组AB都是很长的，其中A有m个数，B有n个数
     * 不借助新数组，如果从前往后比较，那么插入后还需要挪后面的元素，很麻烦，所以这里从后向前比较
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int A[],int m,int B[], int n){
        while (m>0 && n>0){
            if (A[m-1]>B[n-1]){
                A[m+n-1]=A[m-1];
                m--;
            }else {
                A[m+n-1]=B[n-1];
                n--;
            }
        }
        while (n>0){
            A[m+n-1]=B[n-1];
            n--;
        }
    }
}
