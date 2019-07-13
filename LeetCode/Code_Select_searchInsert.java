package com.company.nowLeetCode.Select;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 10:40
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_searchInsert {
    /**
     * 最基本的二分查找，但是最后如果left《right的时候，left，就是那个位置
     * @param A
     * @param target
     * @return
     */
    public static int searchInsert(int[] A,int target){
        if (A==null || A.length==0) return 0;
        return binarySearch(A,0,A.length-1,target);
    }

    public static int binarySearch(int[] A,int left,int right,int target){
        if (left>right) return left;
        int mid=(left+right)/2;
        if (A[mid]==target) return mid;
        else if (A[mid]<target){
            return binarySearch(A,mid+1,right,target);
        }else {
             return binarySearch(A,left,mid-1,target);
        }
    }

    public static void main(String[] args) {
        int[] A=new int[]{1,3,5,6};
        System.out.println(searchInsert(A,2));
    }
}
