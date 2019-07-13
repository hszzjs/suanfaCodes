package com.company.ForTruth.Tencent;

import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/4/11 21:57
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class tanchidexiaoQ {
    /**
     * 每天至少吃一个，最多吃M个
     * 然后就使用二分法来求取能吃的上界
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int N=sc.nextInt(),M=sc.nextInt();
            int start=1,end=M;
            while (start<end){
                int mid=(start+end)/2;
                int count=getSum(mid,N);
                if(M>=count){
                    start=mid;
                }else {
                    end=mid-1;
                }
            }
            System.out.println(end);
        }
    }
    private static int getSum(int mid,int n){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=mid;
            mid=(mid+1)/2;//向上取整
        }
        return sum;
    }
}
