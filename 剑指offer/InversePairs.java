package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/17 12:01
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 参考链接：https://blog.csdn.net/Lynn_Baby/article/details/79638209?utm_source=blogxgwz6
 */
public class InversePairs {
    private int res=0;
    static int[] temp;

    /**
     * 运行时间：596ms，占用内存：53864k
     * @param array
     * @return
     */
    public int InversePairs(int[] array){
        if(array==null|| array.length<=0) return 0;
        temp=new int[array.length];
        sort(array,0,array.length-1);
        return res;
    }
    public void sort(int[] array,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            sort(array,left,mid);
            sort(array,mid+1,right);//使用递归的方法一直将数组一分为二，直到一个数字为一个数组的时候
            merge(array,left,mid,right);
        }
    }
    public void merge(int[] array,int left,int mid,int right){
        int i=left;
        int j=mid+1;
        int current=0;
        while (i<=mid && j<=right){
            if(array[i]>array[j]){
                temp[current++]=array[j++];
                res+=mid-i+1;
                if(res>1000000007) res%=1000000007;
            }else {
                temp[current++]=array[i++];
            }
        }
        while (i<=mid) temp[current++]=array[i++];
        while (j<=right) temp[current++]=array[j++];
        current=0;
        while (left<=right) array[left++]=temp[current++];
    }
}
