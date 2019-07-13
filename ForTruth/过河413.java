package com.company.ForTruth.zijietiaodong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/9 15:31
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * 有n个人要过河，但是河边只有一艘船；船每次最多坐三个人，每个人单独坐船过河的时间为a[i]；
 * 两个人或者三个人一起坐船时，过河时间为他们所有人中的最长过河时间；
 * 为了安全起见，要求每次至少有两个人才能过河。问最短需要多少时间，才能把所有人送过河。
 * 输入格式：
 * 第一行是整数T，表示测试样例个数。
 * 每个测试样例的第一行是一个正整数n，表示参加过河的人数。
 * 第二行是n个正整数a[i]，表示n个人单独过河的时间；
 * 输出格式：
 * 每个测试样例，输出一个最少的过河时间。
 * 每个结果占一行。
 * 数据范围：
 * 2≤n<100000,0<a[i]<100000
 * 示例：
 * 2
 * 2
 * 1 2
 * 4
 * 1 1 1 1
 * 输出：2 3
 * 思路：放弃。
 */
public class 过河413 {
    public static int res;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        while (N-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            res=0;
            process(arr,n);
            System.out.println(res);
        }
    }
    private static void process(int[] arr,int n){
        if(n<=3) res+=arr[n-1];
        if(n==4) res+=arr[3]+arr[2]+arr[1];
        if (n==5){
            int b=arr[1],c=arr[2],d=arr[n-2],e=arr[n-1];
            if(2*c>b+d){
                res+=(d+e+2*b);
            }else {
                res+=(e+2*c+b);

            }
            arr[n-2]=Integer.MAX_VALUE;
            arr[n-1]=Integer.MAX_VALUE;
            Arrays.sort(arr);
            process(arr,n-2);
        }
        if(n==6){
            int a=arr[0],b=arr[1],c=arr[2],d=arr[n-3],e=arr[n-2],f=arr[n-1];
            int min=Math.min(2*d+b+c+f,2*c+2*b+f+d);
            min=Math.min(min,3*b+d+e+f);
            res+=min;
            arr[n-1]=Integer.MAX_VALUE;
            arr[n-2]=Integer.MAX_VALUE;
            arr[n-3]=Integer.MAX_VALUE;
            Arrays.sort(arr);
            process(arr,n-3);
        }
        if(n>=7){
            int a=arr[0],b=arr[1],c=arr[2],d=arr[3], m3=arr[n-3],m2=arr[n-2],m1=arr[n-1];
            int min=Math.min(2*d+c+b+m1,2*c+2*b+m1+m3);
            min=Math.min(min,3*b+m1+m2+m3);
            res+=min;
            arr[n-1]=Integer.MAX_VALUE;
            arr[n-2]=Integer.MAX_VALUE;
            arr[n-3]=Integer.MAX_VALUE;
            Arrays.sort(arr);
            process(arr,n-3);
        }
    }
}
