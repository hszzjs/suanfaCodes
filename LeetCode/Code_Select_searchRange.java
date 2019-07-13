package com.company.nowLeetCode.Select;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 11:38
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_searchRange {
    public static int[] searchRange(int[] A,int target){
        if (A==null || A.length==0) return new int[]{-1,-1};
        int left=0,right=A.length-1,begin=-1,end=-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (A[mid]==target){
                for (int i=mid;i>=left;i--){
                    if (A[i]==target) begin=i;
                    else break;
                }
                for (int i=mid;i<=right;i++){
                    if (A[i]==target) end=i;
                    else break;
                }
                return new int[]{begin,end};
            }else if (A[mid]>target){
                right=mid-1;
            }else left=mid+1;
        }
        return new int[]{begin,end};
    }

    public static void main(String[] args) {
        int[] A=new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(searchRange(A,10)[0]+"="+searchRange(A,10)[1]);
    }
}
