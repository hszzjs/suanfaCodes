package com.company.nowLeetCode.Select;

/**
 * Author:   hszzjs
 * Date:     2019/2/20 9:52
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_SearchInRotatedSortedArrayII {
    /**
     * 这俩题的边界真的好难扣，已经醉了。最好是举例分析各种情况。
     * 宗旨就是二分法
     * 对于重复的，那就谁重复了，谁移动一个位置，毕竟可能是重重复的地方分的
     * @param A
     * @param target
     * @return
     */
    public boolean search(int[] A,int target){
        if (A==null || A.length==0) return false;
        int left=0,right=A.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (target<A[mid]){
                if (A[mid]>A[right]){
                    right=mid-1;
                }else if(A[mid]==A[right]){
                    right--;
                }else if (target<A[left]){
                    left=mid+1;//待定;
                }else right=mid-1;
            }else if (target>A[mid]){
                if (A[mid]>A[left]){
                    left=mid+1;
                }else if (A[mid]==A[left]){
                    left++;
                }else {
                    if (target<A[right]){
                        left=mid+1;
                    }else right=mid-1;
                }
            }else return true;
        }
        return false;
    }
}
