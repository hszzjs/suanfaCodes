package com.company.nowLeetCode.Array;

import java.util.Arrays;

/**
 * Author:   hszzjs
 * Date:     2019/2/17 21:00
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 这个题目真的非常优秀，仔细阅读参考链接：
 * https://www.cnblogs.com/grandyang/p/4465932.html
 */
public class Code_Array_findMedianSortedArrays {
    /**
     * 这题有很大的问题啊。需要好好理的。
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int A[],int B[]){
        int m=A.length,n=B.length,left=(m+n+1)/2,right=(m+n+2)/2;
        //首先由于数组长度奇偶性的不确定，使用小trick得到第 (m+n+1)/2 和(m+n+2)/2 ，然后求平均值作为中值
        //因为时间复杂度log(m+n)的限制，使用二分法（log(2n)）作为查找方法.
        //目的是找到第k个元素,所以创建函数，但是函数使用的参数必然是有k，右两个数组，由于是二分，为了避免拷贝数组，就需要直到数组的起始位置
        //因为总数组的第k个，最起码就是两个数组的前k/2合成k个，要么就是在两个数组的从k/2开始的后半段，总之最安全的范围就是这样去做二分。
        //所以再需要两个变量就是数组的起始位置
        return (findKth(A,0,B,0,left)+findKth(A,0,B,0,right))/2.0;
    }

    /**
     * 这里需要说明下边界位置，因为可能出现其中一个数组很短，就会出现中值还没有找出来，那个数组就起始位置走到尽头，也就是起始位置大于等于长度，
     * 那么接下来就是直接在另一个数组里面从起始位置开始找第k个元素，找到最后就是k==1，就是找到了，需要返回两个数组起始位置的较小值
     * 然后这里的二分就是需要判断起始位置开始加上k/2-1个元素是否超过数组长度，超过就是说当前数组内是没有第k个元素的，所以使得等于系统最大，
     * 如果没有超过就是，找到他的中点位置。根据两个数组中点位置的值判断接下来的起始位置
     * @param nums1
     * @param i
     * @param nums2
     * @param j
     * @param k
     * @return
     */
    public int findKth(int[] nums1,int i,int[] nums2,int j,int k){
        if (i>=nums1.length) return nums2[j+k-1];
        if (j>=nums2.length) return nums1[i+k-1];
        if (k==1) return Math.min(nums1[i],nums2[j]);
        int mid1=(i+k/2-1)>nums1.length?Integer.MAX_VALUE:nums1[i+k/2-1];
        int mid2=(j+k/2-1)>nums2.length?Integer.MAX_VALUE:nums2[j+k/2-1];
        if (mid1>mid2) {
            return findKth(nums1,i,nums2,j+k/2,k-k/2);
        }else {
            return findKth(nums1,i+k/2,nums2,j,k-k/2);
        }
    }

    /**
     * 这个方法原理上与上面是相同的，但是它借助了Arrays里面copy数组的方法，使得不需要起始位置
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays1(int A[],int B[]){
        int m=A.length,n=B.length,left=(m+n+1)/2,right=(m+n+2)/2;
        return (findKth1(A,B,left)+findKth1(A,B,right))/2.0;
    }

    public int findKth1(int[] nums1,int[] nums2,int k){
        int m=nums1.length,n=nums2.length;
        if (m==0) return nums2[k-1];
        if (n==0) return nums1[k-1];
        if (k==1) return Math.min(nums1[0],nums2[0]);
        int mid1=Math.min(m,k/2),mid2=Math.min(n,k/2);
        if (nums1[mid1-1]>nums2[mid2-1]){
            return findKth1(nums1,Arrays.copyOfRange(nums2,mid2,n),k-mid2);
        }else {
            return findKth1(Arrays.copyOfRange(nums1,mid1,m),nums2,k-mid1);
        }
    }

    /**
     * 这个方法使用了迭代形式的二分搜索方法，就是将长数组作为第一个参数，短数组作为第二个参数
     * 妈呀，看不懂，歇一下下次看
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays2(int A[],int B[]){
        return 0.0;
    }
}
