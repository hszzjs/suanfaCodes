package com.company.nowLeetCode.Select;

/**
 * Author:   hszzjs
 * Date:     2019/2/20 8:22
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_SearchInRotatedSortedArray {
    /**
     * 二分
     * @param A
     * @param target
     * @return
     */
    public static int search(int [] A,int target){
        if(A==null||A.length==0)
            return -1;

        int low = 0;
        int high = A.length-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(target < A[mid]){
                if(A[mid]<A[high])//right side is sorted
                    high = mid - 1;//target must in left side
                else
                if(target<A[low])//target<A[mid]&&target<A[low]==>means,target cannot be in [low,mid] since this side is sorted
                    low = mid + 1;
                else
                    high = mid - 1;
            }else if(target > A[mid]){
                if(A[low]<A[mid])//left side is sorted
                    low = mid + 1;//target must in right side
                else
                if(target>A[high])//right side is sorted. If target>A[high] means target is not in this side
                    high = mid - 1;
                else
                    low = mid + 1;
            }else
                return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] A=new int[]{};
        System.out.println(search(A,15));
    }
}
