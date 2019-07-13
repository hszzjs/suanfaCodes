package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/11/29 22:06
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 * 算法思路：
 * 没别的，就是需要判断exponent的正负情况
 */
public class Power {
    /**
     * 运行时间：60ms，占用内存：10652k
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base,int exponent){
        double out=1;
        if(exponent>0){
            for(int i=1;i<=exponent;i++){
                out=out*base;
            }
        }else if(exponent<0){
            double dao=1/base;
            for(int i=1;i<=-exponent;i++){
                out=out*dao;
            }
        }else return 1;
        return out;
    }
}
