package com.company.nowLeetCode.Array;


import java.util.Arrays;

/**
 * Author:   hszzjs
 * Date:     2019/2/22 22:04
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_threeSumClosest {
    /**
     * 暴力直接做，一次三个指针遍历，时间复杂度O(n^3)，绝对值最小就是最接近
     * @param num
     * @param target
     * @return
     */
    public int threeSumClosest(int[] num,int target){
        if (num==null || num.length==0) return 0;
        if (target>Integer.MAX_VALUE || target<Integer.MIN_VALUE) return 0;
        int min=Integer.MAX_VALUE;
        int sum=0,res=0;
        for (int i=0;i<num.length-2;i++){
            for (int j=i+1;j<num.length-1;j++){
                for (int k=j+1;k<num.length;k++){
                    sum=num[i]+num[j]+num[k];
                    int abs=Math.abs(sum-target);
                    if (min>abs){
                        min=abs;
                        res=sum;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 相较于，这个方法的时间复杂度明显降低，不过这个不是从前往后这样一遍遍刷，是选择使用Arrays.sort先去排序，
     * 然后第一个数从前往后遍历，剩下两个数使用left与right从两个端前进，直至相遇，然后就是绝对值要最小，而且一次只能移动一个指针，
     * 根据sum与target的比较判断left前进还是right前进，一旦相等就直接返回，毕竟最近。
     * 时间复杂度大大提高，主要原因在于排序后，大小有了规律，判断很轻易。
     * @param num
     * @param target
     * @return
     */
    public int threeSumClosest1(int[] num,int target){
        if (num.length<3) return 0;
        int min=Integer.MAX_VALUE;
        int left,right,sum,res=0;
        Arrays.sort(num);
        for (int i=0;i<num.length-2;i++){
            left=i+1;
            right=num.length-1;
            while (left<right){
                sum=num[i]+num[left]+num[right];
                if (Math.abs(sum-target)<min){
                    min=Math.abs(sum-target);
                    res=sum;
                }
                if (sum>target) right--;
                if (sum<target) left++;
                if (sum==target) return target;
            }
        }
        return res;
    }
}
