package com.company.nowLeetCode.Array;

import java.util.Arrays;
import java.util.EventListener;

/**
 * Author:   hszzjs
 * Date:     2019/2/22 13:25
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_firstMissingPositive {
    /**
     * 这个就是基本的baseCase需要想到，有重复数字，0不算
     * @param A
     * @return
     */
    public static int firstMissingPositive(int[] A){
        if (A.length==0 || (A.length==1 && (A[0]<0 || A[0]>1))) return 1;
        Arrays.sort(A);
        boolean T=false;
        for (int i=0;i<A.length;i++){
            if (i!=A.length-1){
                if (A[i]<0) {
                    T=false;
                    continue;
                }
                if (!T){
                    if (A[i]!=1 && A[i]!=0) return 1;
                    else if (A[i]+1==A[i+1]) {
                        T=true;
                        continue;
                    }
                }
                if (A[i]+1==A[i+1] || A[i]==A[i+1]) {
                    T=true;
                    continue;
                }
                if (A[i]+1!=A[i+1]) return A[i]+1;
            }else {
                if (A[i]<=0 || A[i]>1) return T?A[i]+1:1;
                else return 2;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] A=new int[]{-2,-3,0,1,1,2};
        System.out.println(firstMissingPositive(A));
    }
}
