package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 20:21
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_removeDuplicates {
    /**
     * 这个使用双指针，就是将重复的不挪，重复的挪一挪，len是作为稍后的指针，index是在前面走的指针
     * @param A
     * @return
     */
    public int removeDuplicates(int[] A){
        if (A.length==0 || A==null) return 0;
        int len=1;
        for (int index=1;index<A.length;index++){
            if (A[index]!=A[index-1]){
                if (A[index]!=A[len]){
                    A[len]=A[index];
                }
                len++;
            }
        }
        return len;
    }
}
