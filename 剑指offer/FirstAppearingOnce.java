package com.company.offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author:   hszzjs
 * Date:     2018/12/24 9:21
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：字节流中第一个不重复的字符
 * 算法思路：使用哈希map以及ArrayList来分别存字符出现的次数以及出现过的字符
 * 参考链接：https://blog.csdn.net/snow_7/article/details/51934456
 */
public class FirstAppearingOnce {
    HashMap<Character,Integer> map=new HashMap<>();
    ArrayList<Character> list=new ArrayList<>();
    public void Insert(char ch){
        if (map.containsKey(ch)) map.put(ch,map.get(ch)+1);
        else map.put(ch,1);
        list.add(ch);
    }
    public char FirstAppearingOnce(){
        char ch='#';
        for(int i=0;i<list.size();i++){
            if(map.get(list.get(i))==1){
                ch=list.get(i);
                break;
            }
        }
        return ch;
    }
}
