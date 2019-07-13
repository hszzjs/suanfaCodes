package com.company.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author:   hszzjs
 * Date:     2018/12/16 20:40
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 注意：排序时一定要使用Integer数组进行排序，int类型不能使用。
 */
public class PrintMinNumber {
    /**
     * 运行时间36ms，占用内存9768k
     * 算法思路：关键就是创建一个比较器，直接就是使用连接判断。重点还是使用了Arrays.sort这个函数
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int[] numbers){
        if(numbers.length==0||numbers==null) return "";
        Integer[] nums=new Integer[numbers.length];
        for (int i=0;i<numbers.length;i++){
            nums[i]=new Integer(numbers[i]);
        }
        Comparator<Integer> cmp=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1=o1+""+o2;
                String str2=o2+""+o1;
                return str1.compareTo(str2);
            }
        };
        Arrays.sort(nums,cmp);
        StringBuffer sb=new StringBuffer();
        for(int val:nums)
            sb.append(val);
        return sb.toString();
    }
}
