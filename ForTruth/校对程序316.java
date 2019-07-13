package com.company.ForTruth.zijietiaodong;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/7 10:06
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * 自定义了程序的校对模式：
 * 1.三个同样的字母连在一起，一定是拼写错误，去掉一个就好了。比如:helllo --> hello
 * 2.两对一样的字母(AABB型)连在一起，一定是拼写错误，去掉第二对的第一个字母。比如:helloo --> hello
 * 3.上面的规则优先“从左到右”匹配，即如果是AABBCC型，应优先考虑修复AABB为AABCC。
 * 输入描述：第一行包括一个数字N，表示待校验字符串个数，后面跟随N行，表示待校验的字符串
 * 输出描述：N行，每行为修复后的字符串
 * 示例：
 * 2
 * helloo
 * woooooow
 * 输出：
 * hello
 * woow
 */
public class 校对程序316 {
    /**
     * 这个如果真的去抠边界条件，真的很麻烦，毕竟我扣了好久都没成。然后暴力，因为是从左到右匹配，
     * 所以就先处理三个相同的字母，然后处理AABB形式。根据百度到的，有人这样做是AC了的。所以
     * 基于此，希望如果边界条件很难抠，然后暴力比较快，那就不妨使用暴力看能否AC。
     * @param args
     */
    public static void main0(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String[] strs=new String[N];
        for(int i=0;i<N;i++){
            strs[i]=sc.nextLine().trim();
        }
        sc.close();
        for (String str:strs){
            char[] chars=str.toCharArray();
            //直接处理三个同样的字母
            for(int i=0;i<chars.length-2;i++){
                if(chars[i]==chars[i+1] && chars[i]==chars[i+2]) chars[i]='#';
            }
            str=String.valueOf(chars).replaceAll("#","");
            chars=str.toCharArray();
            //处理AABB形式
            for(int i=2;i<chars.length-2;i++){
                if(chars[i-1]==chars[i-2] && chars[i]==chars[i+1]) chars[i]='#';
            }
            str=String.valueOf(chars);
            System.out.println(str.replaceAll("#",""));
        }
    }

    /**
     * 这个让我的想法就是脑子瓦特了，我之前一直纠结于如何使用StringBuffer，结果这个直接使用ArrayList
     * 动态判断，很优秀！但是时间复杂度和前面是一样的。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        for(int i=0;i<num;i++){
//            System.out.println(modify(sc.nextLine()));
            System.out.println(checkedWord(sc.nextLine()));
        }
    }

    public static String modify(String str){
        ArrayList<Character> list=new ArrayList<>();//使用动态数组存储
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            int size=list.size();
            //前一个字符与当前字符不同，或者字符串前两个字符时
            if(size<1 || list.get(size-1)!=c) list.add(c);
            else {
                if(list.get(size-2)==c) continue;//三个相同字符
                else {
                    //不是AABB型
                    if (size==2 ||list.get(list.size()-2)!=list.get(list.size()-3)){
                        list.add(c);
                    }
                }
            }
        }
        String res="";
        for (int i=0;i<list.size();i++){
            res+=list.get(i);
        }
        return res;
    }
    //这个时间复杂度稍低一点
    //一度认为我的脑袋是浆糊
    public static String checkedWord(String word){
        if(word.isEmpty()) System.out.println("");
        char[] chars=word.toCharArray();
        int cur_cout=0;
        int pre_count=0;
        for(int i=0;i<chars.length;i++){
            if(i==0){
                cur_cout=1;
                continue;
            }
            if (chars[i]==chars[i-1]){
                cur_cout++;
                if (cur_cout==3){
                    chars[i-2]='#';//这里处理的是i-2项，就是为了接下来看AABB型
                    cur_cout=2;
                }
                if (cur_cout==2 && pre_count==2){
                    chars[i-1]='#';
                    cur_cout=1;
                }
            }else {
                pre_count=cur_cout;
                cur_cout=1;
            }
        }
        String res=String.valueOf(chars);
        return res.replaceAll("#","");
    }
}
