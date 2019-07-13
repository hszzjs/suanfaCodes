package com.company.nowLeetCode.Array;

import java.util.Arrays;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 15:26
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_longestConsecutive {
    /**
     * 反正一直没明白目的，说明下，就是直接找到连续数字的种类数，如果有重复的跳过就可以
     * 不一定非得按照网上说的使用HashSet
     * @param num
     * @return
     */
    public static int longestConsecutive(int[] num){
        if (num==null || num.length==0) return 0;
        Arrays.sort(num);
        int res=1,sum=1,cnt=1;
        for (int i=0;i<num.length-1;i++){
            if (num[i]+1==num[i+1]){
                sum+=1;
                cnt=1;
            }else if (num[i]==num[i+1]){
                cnt+=1;
            }else {
                res=Math.max(res,sum);
                cnt=1;
                sum=1;
            }
        }
        return Math.max(sum,res);
    }

    public static void main(String[] args) {
        int[] num=new int[]{0,0,1,2,2};
        System.out.println(longestConsecutive(num));
    }
}
