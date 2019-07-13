package com.company.nowLeetCode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 13:13
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_anagrams {
    /**
     * 说下题意，就是看数组中有哪些单词是属于同一个变形词变的，属于就返回。
     * 判断是否是，使用了HashMap，key使用字符数组排序后的字符串作为，独一无二。然后判断就可以。
     * @param strs
     * @return
     */
    public ArrayList<String> anagrams(String[] strs){
        ArrayList<String> res=new ArrayList<>();
        if (strs==null ||strs.length==0) return res;
        HashMap<String,ArrayList<String>> hashMap=new HashMap<>();
        for (String str:strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);//字符串排序作为独一无二的key
            String newStr=new String(chars);
            if (hashMap.containsKey(newStr)){
                if (hashMap.get(newStr).size()==1){//由于第一个放入的还没有加入到res中，判断下加入
                    res.add(hashMap.get(newStr).get(0));
                }
                hashMap.get(newStr).add(str);
                res.add(str);
            }else {//还没有当前key，那就创建并添加
                ArrayList<String> list=new ArrayList<>();
                list.add(str);
                hashMap.put(newStr,list);
            }
        }
        return res;
    }
}
