package com.company.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:   hszzjs
 * Date:     2018/12/26 19:15
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：数据流中的中位数
 */
public class Median {
    public List<Integer> list= new ArrayList<>();
    public void Insert(Integer num){
        list.add(num);
    }

    public Double GetMedian(){
        double median=0;
        if (list.size()==0) return median;
        Integer[] arr=list.toArray(new Integer[list.size()]);
        Arrays.sort(arr);
        if (arr.length%2==0) median=(arr[arr.length/2-1]+arr[arr.length/2])/2.0;
        else median=arr[arr.length/2];
        return median;
    }
}
