package com.company.offer;

import java.util.Arrays;

/**
 * Author:   hszzjs
 * Date:     2018/12/16 8:51
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 参考链接：https://blog.csdn.net/weixin_37672169/article/details/80894301
 */
public class MoreThanHalfNum_Solution {
    /**
     * 运行时间18ms，占用内存：9440k
     * 算法思路：题目的意思另一种解读就是一个数字出现的次数比其他所有数字出现次数的和还要多。那么也就是遍历数组，只要两个值，一个是数组的数字，
     * 一个是该数字抵消其它数之后的次数。也就是res作为当前数，次数为1，下一个数如果与它不同那就两者抵消，然后开始下下一个数作为当前数，
     * 这样抵消下去多的那个数总是会留下来的，最后重新计算数组中该数出现的次数是不是超过一半就可以。
     * @param array
     * @return
     */
    /**
    public int MoreThanHalfNum_Solution(int[] array){
        if(array.length==0) return -1;
        int result=array[0];
        int cnt=1;
        for(int i=1;i<array.length;i++){
            if(cnt==0){
                result=array[i];
                cnt=1;
            }else if(array[i]==result) cnt++;
            else cnt--;
        }
        cnt=0;
        for (int i=0;i<array.length;i++){
            if(array[i]==result) cnt++;
        }
        if(cnt<=array.length/2){
            return 0;
        }
        return result;
    }
     */
    /**
     * 运行时间22ms，占用内存：9528k
     * 算法思路：
     * 这个的重点就是将数组排序了，如果有出现次数超过数组长度一半的数字，那么就意味着，排序后数组最中间的数就是那个数，
     * 只要将数组中的该数统计下有多少个就可以了。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array){
        int len=array.length;
        if(len<1) return 0;
        int count=0;
        Arrays.sort(array);
        int num=array[len/2];
        for(int i=0;i<len;i++){
            if(num==array[i]) count++;
        }
        if(count<=(len/2)) num=0;
        return num;
    }
}
