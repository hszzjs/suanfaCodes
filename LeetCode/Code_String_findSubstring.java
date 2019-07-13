package com.company.nowLeetCode.String;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 21:17
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_findSubstring {
    /**
     * 说明下题意，就是题目中可能这个字符串数组中的字符串随意组合连接在一起多次出现，要获取每次出现的起始位置。
     * 这里流选择使用HashMap以及遍历的方法解决，事实上，不知道为什么，网上找的以前的代码baseCase没有通过。
     * 就是首先将L中的字符串全部进行统计，统计每个字符串出现的次数。然后就是从头开始遍历s这个字符串查找了，
     * 数组中字符串个数为num，字符串长度为len，记住遍历到剩下不足num*len的字符就不用再遍历了。
     * 使用一个新的HashMap记录从i开始取len个字符作为单词，看之前的map有没有当前单词的键，没有那么i就可以前进，
     * 有那就记录它的个数，一旦出现这个map中当前单词的个数多余之前的map，那就不满足条件，i前进，记得记录下当下验证的的单词数目，
     * 一旦数目达到num那就可以加到res中，然后重新开始了
     * @param s
     * @param L
     * @return
     */
    public ArrayList<Integer> findSubstring(String s,String[] L){
        ArrayList<Integer> res=new ArrayList<>();
        HashMap<String,Integer> LMap= new HashMap<>();
        HashMap<String,Integer> tmpMap=new HashMap<>();
        int num=L.length,len=L[0].length();
        for (String l:L){
            if (LMap.containsKey(l)){
                LMap.put(l,LMap.get(l)+1);
            }else {
                LMap.put(l,1);
            }
        }
        for (int i=0;i<s.length()-num*len+1;i++){
            int cnt=0;
            tmpMap.clear();
            for (int j=i;j<num*len+i;j+=len){
                String tmp=s.substring(j,j+len);
                if (LMap.containsKey(tmp)){
                    if (tmpMap.containsKey(tmp)){
                        tmpMap.put(tmp,tmpMap.get(tmp)+1);
                    }else tmpMap.put(tmp,1);
                    cnt++;
                }else break;
                if (tmpMap.get(tmp)>LMap.get(tmp)) break;
                if (cnt==num) res.add(i);
            }
        }
        return res;
    }
}
