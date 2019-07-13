package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 21:05
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_sortColors {
    /**
     * 使用三指针，从头找到notred的起始指针，从后找到notblue的起始指针，然后开始动指针i从notred开始，
     * A[i]如果开始为red那就与notred交换，notred++前移，i也前移，如果A[i]是blue，那就与blue交换，notblue--后移
     * @param A
     */
    public void sortColors(int[] A){
        if (A==null || A.length==0) return;
        int len=A.length;
        int notred=0,notblue=len-1;
        while (notred<len && A[notred]==0)
            notred++;
        while (notblue>=0 && A[notblue]==2)
            notblue--;
        int i=notred;
        while (i<=notblue){
            if (A[i]==0) {
                swap(A,i,notred);
                notred++;
                i++;//这个要i++
            }else if (A[i]==2) {
                swap(A,i,notblue);
                notblue--;
            }else i++;
        }
    }

    public void swap(int[] A,int i,int j){
        int tmp=A[i];
        A[i]=A[j];
        A[j]=tmp;
    }
}
