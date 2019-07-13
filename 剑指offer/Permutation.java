package com.company.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author:   hszzjs
 * Date:     2018/12/10 14:08
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Permutation {
    /**
     * 递归方法：运行时间164ms，占用内存11872k
     * 参考链接：https://blog.csdn.net/lynn_baby/article/details/79736771
     * @param str
     * @return
     */
    /**
    public ArrayList<String> Permutation(String str){
        ArrayList<String> res=new ArrayList<>();
        if(str!=null && str.length()>0){
            CharSort(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return res;
    }
    private void CharSort(char[] ch,int start,ArrayList<String> res){
        char data;
        if(start==ch.length-1){
            res.add(String.valueOf(ch));
        }else{
            for(int i=start;i<ch.length;i++){
                if(i==start||ch[i]!=ch[start]){
                    data=ch[start];
                    ch[start]=ch[i];
                    ch[i]=data;
                    CharSort(ch,start+1,res);
                    data=ch[start];
                    ch[start]=ch[i];
                    ch[i]=data;
                }
            }
        }
    }
     */
    /**
     * 非递归方法，运行时间172ms，占用内存12184k
     * 参考链接：https://blog.csdn.net/weixin_41835916/article/details/80729537
     * @param str
     * @return
     */

    public ArrayList<String> Permutation(String str){
        ArrayList<String> res=new ArrayList<>();
        if(str!=null && str.length()>0){
            char[] seq=str.toCharArray();
            Arrays.sort(seq);
            res.add(String.valueOf(seq));
            int len=seq.length;
            while (true){
                int i=len-1,m;
                while (i>0&&seq[i-1]>=seq[i]) i--;
                if (i==0) break;
                m=i;i--;
                while (m<len&&seq[m]>seq[i]) m++;
                m--;
                swap(seq,m,i);
                reverse(seq,i+1);
                res.add(String.valueOf(seq));
            }
        }
        return res;
    }
    private void reverse(char[] seq,int start){
        int len;
        if(seq==null || (len=seq.length)<=start) return;
        for (int i=0;i<((len-start)/2);i++){
            int p=start+i,q=len-1-i;
            if(p!=q) swap(seq,p,q);
        }
    }
    private void swap(char[] cs,int i,int j){
        char t=cs[i];
        cs[i]=cs[j];
        cs[j]=t;
    }
}
/**
 * 思路2(摘自牛客网)：
 *
 * 字典序排列算法
 *
 * 可参考解析： http://www.cnblogs.com/pmars/archive/2013/12/04/3458289.html  （感谢作者）
 *
 * 一个全排列可看做一个字符串，字符串可有前缀、后缀。
 * 生成给定全排列的下一个排列.所谓一个的下一个就是这一个与下一个之间没有其他的。
 * 这就要求这一个与下一个有尽可能长的共同前缀，也即变化限制在尽可能短的后缀上。
 *
 * [例]839647521是1--9的排列。1—9的排列最前面的是123456789，最后面的987654321，
 * 从右向左扫描若都是增的，就到了987654321，也就没有下一个了。否则找出第一次出现下降的位置。
 *
 * 【例】 如何得到346987521的下一个
 * 1，从尾部往前找第一个P(i-1) < P(i)的位置
 * 3 4 6 <- 9 <- 8 <- 7 <- 5 <- 2 <- 1
 * 最终找到6是第一个变小的数字，记录下6的位置i-1
 *
 * 2，从i位置往后找到最后一个大于6的数
 * 3 4 6 -> 9 -> 8 -> 7 5 2 1
 * 最终找到7的位置，记录位置为m
 *
 * 3，交换位置i-1和m的值
 * 3 4 7 9 8 6 5 2 1
 * 4，倒序i位置后的所有数据
 * 3 4 7 1 2 5 6 8 9
 * 则347125689为346987521的下一个排列
 *
 */