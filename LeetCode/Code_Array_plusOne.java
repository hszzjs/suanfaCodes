package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 21:45
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_plusOne {
    /**
     * 主要就是判断有没有溢出
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits){
        int tmp=0;
        for (int i=digits.length-1;i>=0;i--){
            if ((i==digits.length-1?digits[i]+1+tmp:digits[i]+tmp)>9){
                if (i==digits.length-1){
                    digits[i]=digits[i]+1+tmp-10;
                }else {
                    digits[i]=digits[i]+tmp-10;
                }
                tmp=1;
            }else {
                if (i==digits.length-1){
                    digits[i]=digits[i]+1+tmp;
                }else {
                    digits[i]=digits[i]+tmp;
                }
                tmp=0;
                break;
            }
        }
        if (tmp==0) return digits;
        else {
            int[] res=new int[digits.length+1];
            res[0]=1;
            for (int i=1;i<res.length;i++)
                res[i]=digits[i-1];
            return res;
        }
    }
}
