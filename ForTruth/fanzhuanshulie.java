package com.company.ForTruth.Tencent;

import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/4/11 22:05
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class fanzhuanshulie {
    /**
     * 这个是找规律的问题，由于n可以被2m整除，所以是恰好可以分为n/2m组
     * 然后就是发现每组的和是固定的m^2
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            long n=sc.nextInt(),m=sc.nextInt();
            System.out.println(n*m/2);
        }
    }
}
