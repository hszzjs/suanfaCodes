package com.company.nowLeetCode.String;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 21:49
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_strStr {
    /**
     * 题意：给定一个 haystack 字符串和一个 needle 字符串，
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)开始到之后的的所有字符串。
     * 下面是常规做法
     * 有一个关键就是有人说使用KMP算法，所以这个得记录下
     * KMP学习连接：https://blog.csdn.net/v_july_v/article/details/7041827
     * @param haystack
     * @param needle
     * @return
     */
    public String strStr(String haystack,String needle){
        if (haystack==null || needle==null) return null;
        if (needle.length()==0) return haystack;
        int len1=haystack.length();
        int len2=needle.length();
        for (int i=0;i<len1-len2;i++){
            int j=0;
            for (;j<len2;j++){
                if (haystack.charAt(i+j)!=needle.charAt(j)) break;
            }
            if (j==len2) return haystack.substring(i);
        }
        return null;
    }
}
