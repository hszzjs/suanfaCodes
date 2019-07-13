package com.company.offer;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2018/12/18 21:37
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 参考链接：https://blog.csdn.net/weixin_41835916/article/details/80816364
 */
public class FindNumbersWithSum {
    /**
     * 运行时间17ms，占用内存9284k
     * 算法思路：首先是递增排序的数组，所以使用两个指针从两头前进，得到的第一对数作为答案
     * 原因在于计算发现，凡是和相同的两个数，按照顺序排下来，会发现最外面的两个数积最小。所以这样的方法是具有可行性的。
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array,int sum){
        ArrayList<Integer> res=new ArrayList<>();
        if (array==null||array.length<2) return res;
        int i=0,j=array.length-1;
        while (i<j){
            if (array[i]+array[j]==sum){
                res.add(array[i]);
                res.add(array[j]);
                return res;
            }else if (array[i]+array[j]>sum) j--;
            else i++;
        }
        return res;
    }
}
