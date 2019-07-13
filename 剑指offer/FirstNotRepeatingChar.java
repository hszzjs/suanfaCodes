package com.company.offer;

import java.util.HashMap;

/**
 * Author:   hszzjs
 * Date:     2018/12/17 11:07
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）
 */
public class FirstNotRepeatingChar {
    /**
     * 运行时间45ms，占用内存10016k
     * 参考链接：https://blog.csdn.net/lingongheng/article/details/52737471
     * 算法思路：
     * 使用HashMap，字符作为键，出现的次数作为值，这里注意就是创建新的键值对还是原有值+1
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str){
        if(str==null || str.length()==0) return -1;
        char[] chars=str.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(map.get(chars[i])!=null) map.put(chars[i],map.get(chars[i])+1);
            else map.put(chars[i],1);
        }
        for(int i=0;i<str.length();i++){
            if(map.get(chars[i])==1) return i;
        }
        return -1;
    }
}
