package com.company.ForTruth.zijietiaodong;

/**
 * Author:   hszzjs
 * Date:     2019/4/11 9:20
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * 有N根绳子，第i根绳子长度为Li，现在需要M根等长的绳子，你可以对n根绳子进行任意裁剪（不能拼接），
 * 请你帮忙计算出这m根绳子最长的长度是多少。
 * 输入描述：
 * 第一行包含2个正整数N、M，表示N根原始的绳子，和最终需要M根绳子数
 * 第二行包含N个整数，第i个整数Li表示第i根绳子的长度，其中
 * 1 <= N、M <= 100000,0 < Li < 10 0000 0000
 * 输出描述：
 * 对每一个测试用例，输出一个数字，表示裁剪后最长的长度，保留两位小数。
 *
 * 示例：
 * 输入：
 * 3 4
 * 3 5 4
 * 输出：2.50，即第一根和第三根分别裁剪出一根2.50长度的绳子，第二根剪成2根2.50长度的绳子，刚好4根
 * 备注：40% 数据 M <= N
 *
 * 思路：
 * 这个题就是尝试，但是到底尝试多长呢？就从0到最大值Integer.MAX_VAlUE使用二分法来尝试。
 */
public class 剪绳子316 {
    public static double getMaxLength(double[] ropes,int M ){
        int[] arr=new int[ropes.length];
        for(int i=0;i<ropes.length;i++){
            arr[i]=(int)(ropes[i]*100);
        }
        int l=0,mid=0,res=0;
        int r=Integer.MAX_VALUE;
        while (l<r){
            mid=(l+r)>>1;//右移1位相当于除以2
            if(mid==0) break;
            if (isValid(arr,mid,M)){
                res=mid+1;
                l=mid+1;
            }else r=mid-1;
        }
        return res/100.0d;
    }

    public static boolean isValid(int[] arr,int value,int m){
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i]/value;
        }
        return sum>=m;
    }

    public static void main(String[] args) {
        System.out.println(getMaxLength(new double[]{3,5,4},7));
    }
}
