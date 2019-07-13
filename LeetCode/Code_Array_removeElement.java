package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/22 19:41
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_removeElement {
    /**
     *  来，讲一件很扯的事情，事实上从前往后暴力前移，使用指针，按照题意应该可以，但是
     *  baseCase里面竟然走的是把后面的不是替换成前面的是，否则就会报错，所以就只能使用双指针
     * @param A
     * @param elem
     * @return
     */
    public int removeElement(int[] A,int elem){
        if (A==null || A.length==0) return 0;
        int len=0;
        for (int i=0;i<A.length;i++){
            if (A[i]!=elem){
                if (A[i]!=A[len]){
                    A[len]=A[i];
                }
                len++;
            }
        }
        return len;
    }

    public int removeElement1(int[] A, int elem){
        if (A==null || A.length==0) return 0;
        int left=0,right=A.length-1,tmp=0,len=A.length;
        while (left<=right){
            while (left<=right && A[left]!=elem) left++;
            while (right>=left && A[right]==elem) {
                right--;
                len--;
            }
            if (left<=right){
                tmp=A[left];
                A[left]=A[right];
                A[right]=tmp;
                right--;
                left++;
                len--;
            }
        }
        return len;
    }
}
