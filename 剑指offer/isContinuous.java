package com.company.offer;

import java.util.Arrays;

/**
 * Author:   hszzjs
 * Date:     2018/12/19 11:12
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：扑克牌顺子
 */
public class isContinuous {
    /**
     * 运行时间28ms，占用内存9312k
     * 参考链接：https://blog.csdn.net/abc7845129630/article/details/52821911
     * 算法思路：这个算法事实上有点绕，刚好有直接了当的算法。
     * @param numbers
     * @return
     */
    /**
    public boolean isContinuous(int[] numbers){
        if(numbers==null||numbers.length!=5) return false;
        int countOf0=(numbers[0]==0?1:0);
        int dis=0;
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]==0) countOf0++;
            int t=numbers[i];
            int j=0;
            for(j=i-1;j>=0;j--){
                if(t!=0&&t==numbers[j]) return false;//重复数字
                else if (t>numbers[j]) break;//先不管是否连续，只要满足大小排序就可以
                else numbers[j+1]=numbers[j];
            }
            numbers[j+1]=t;
        }
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]!=0) dis+=numbers[i+1]-numbers[i]-1;
        }
        if(dis<=countOf0) return true;
        return false;
    }
     */
    /**
     * 运行时间：15ms，占用内存：9280k
     * 参考链接：https://blog.csdn.net/zjxxyz123/article/details/79777109
     * 算法思路：就先将数组排序，宏观上去考虑，不管0的数目，如果这个数组的max与min相差大于4，那么就必然不会是顺子，
     * 如果出现了非0的重复元素，就肯定不是顺子，顺子要满足：
     * max-min<5;
     * 非0元素不重复；
     * 直接遍历数组就可以实现。
     * @param numbers
     * @return
     */
    public boolean isContinuous(int[] numbers){
        if(numbers==null|| numbers.length!=5) return false;
        Arrays.sort(numbers);
        int numOfzero=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0){
                numOfzero++;
                continue;
            }else {
                if(i-1>=0 && numbers[i-1]==numbers[i]) return false;
                if (i-1>=0&&numbers[i-1]!=0){
                    int numOfintervel=numbers[i]-numbers[i-1]-1;
                    if(numOfintervel>numOfzero) return false;
                    numOfzero-=numOfintervel;
                }
            }
        }
        return true;
    }
}
