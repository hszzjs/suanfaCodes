package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 20:39
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_removeDuplicatesII {
    /**
     * 依旧双指针，就是要在遇到重复项的时候进行下计数
     * @param A
     * @return
     */
    public static int removeDuplicates(int[] A){
        if (A==null ||A.length==0) return 0;
        int len=1,cnt=1;
        for (int i=1;i<A.length;i++){
            if (A[i]==A[i-1]) {
                cnt+=1;
                if (cnt==2){
                    if (A[i]!=A[len]) {
                        A[len]=A[i];
                    }
                    len+=1;
                }
                cnt=0;
            }
            else {
                cnt=1;
                if (A[i]!=A[len]) {
                    A[len]=A[i];
                }
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] A={1,1,2,2,2};
        System.out.println(removeDuplicates(A));
    }
}
