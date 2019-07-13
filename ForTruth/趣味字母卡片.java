package com.company.ForTruth.拼夕夕;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/14 21:09
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 小明给儿子小小明买了一套英文字母卡片（总共包含52张，区分大小写），小小明把卡片丢在地上玩耍，并从中取出若干张排成一排，形成了一个卡片序列。
 此时，小明需要将卡片序列中的重复字母剔除（同一个字母的大小写只保留一个）。
 请问，所有可能的结果中，字母序最小（不区分大小写）的序列的第一张卡片上是哪个字母？
 输入格式
 共一行，包含一个非空字符串，表示卡片序列，长度为N。
 输出格式
 共一行，包含一个字母（如果结果是大写字母，则需要转换成小写）。
 数据范围
 1≤N≤52
 输入样例：
 xaBXY
 输出样例：
 a
 样例解释
 剔除完后的结果是abxy。
 */
public class 趣味字母卡片 {
    /**
     * 这个题目就是每次事实上不知道到底去除其重复字母前面的那个还是后面的那个，是一个变化的。所以如果不断去判断去除不去除很麻烦，
     * 那就暴力遍历。直接a~z开始遍历，假设a，先对于字符串中的字符进行统计次数，然后如果a前面的字母均可以被去除，即均a前面的字母
     * 出现次数是大于1的。并且在遍历到a那个位置为止，并不是全部出现完了。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine().toLowerCase();
        char[] chars=str.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:chars){
            if(!map.keySet().contains(c)) map.put(c,1);
            else map.put(c,map.get(c)+1);
        }
        boolean T=false;
        for(char c='a';c<='z';c++){
            HashMap<Character,Integer> map1=new HashMap<>(map);
            if(!map1.keySet().contains(c)) continue;
            for(int i=0;i<chars.length;i++){
                char t=chars[i];
                if(t==c) {
                    T=true;
                    break;
                }
                if(map1.get(t)==1) break;
                map1.put(t,map1.get(t)-1);
            }
            if (T) {
                System.out.println(c);
                break;
            }
        }
    }
}
