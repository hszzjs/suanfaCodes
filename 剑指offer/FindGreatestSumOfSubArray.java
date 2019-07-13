package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/16 10:34
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：连续子数组的最大和
 */
public class FindGreatestSumOfSubArray {
    /**
     * 运行时间23ms，占用内存：9500k
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array){
        int sum=array[0];
        int max=array[0];
        for(int i=1;i<array.length;i++){
            if(sum>=0) sum+=array[i];//求最大和，就是如果前面的和都小于0了，那么对于获取所谓的最大和是一点用都没有，所以需要重新开始计算
            else sum=array[i];
            if(sum>max) max=sum;//如果求到的和比之前记录的最大值大，那么就进行更新
        }
        return max;
    }
}
