package com.company.nowLeetCode.Select;

import java.util.*;

/**
 * Author:   hszzjs
 * Date:     2019/2/18 18:06
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_ladderLength {
    public static int ladderLength(String start, String end, HashSet<String> dict){
        dict.add(start);
        dict.add(end);
        HashMap<String,ArrayList<String>> hashMap=getNexts(dict);
        HashMap<String ,Integer> res=getDistances(start,hashMap);
        return res.get(end)+1;
    }

    public static HashMap<String ,ArrayList<String>> getNexts(HashSet<String> dict){
        HashMap<String, ArrayList<String>> nexts = new HashMap<>();
        for (String s:dict) {
            nexts.put(s, new ArrayList<>());
        }
        for (String s:dict) {
            nexts.put(s, getNext(s, dict));
        }
        return nexts;
    }

    private static ArrayList<String> getNext(String word, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char[] chs = word.toCharArray();
        for (char cur = 'a'; cur <= 'z'; cur++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] != cur) {
                    char tmp = chs[i];
                    chs[i] = cur;
                    if (dict.contains(String.valueOf(chs))) {
                        res.add(String.valueOf(chs));
                    }
                    chs[i] = tmp;
                }
            }
        }
        return res;
    }

    public static HashMap<String,Integer> getDistances(String begin,HashMap<String,ArrayList<String>> nexts){
        HashMap<String,Integer> res=new HashMap<>();
        res.put(begin,0);
        Queue<String> queue=new LinkedList<>();//用于深度优先搜索，先进先出，一个等级完毕，就是下一个等级
        queue.add(begin);
        HashSet<String> hashSet=new HashSet<>();//用于存储搞过的单词
        hashSet.add(begin);
        while (!queue.isEmpty()){
            String cur=queue.poll();
            ArrayList<String> next=nexts.get(cur);
            for (String word:next){
                if (!hashSet.contains(word)){
                    res.put(word,res.get(cur)+1);
                    hashSet.add(word);
                    queue.add(word);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        HashSet<String> dict=new HashSet<>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
//        dict.add("lot");
//        dict.add("log");
        System.out.println(ladderLength("a","c",dict));
    }
}
