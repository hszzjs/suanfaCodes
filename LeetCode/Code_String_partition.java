package com.company.nowLeetCode.String;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 11:53
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_partition {
    /**
     * 这个题目就是从头至尾这样去切割字符串，每一种切法的目的就是切出来的每一个必须是回文的。
     * 所以就从头至尾暴力递归去切，切完回文就继续切，直到切完。
     * @param s
     * @return
     */
    public ArrayList<ArrayList<String>> partition(String s){
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        ArrayList<String > list=new ArrayList<>();
        if (s==null || s.length()==0) return res;
        process(s,0,res,list);
        return res;
    }

    public void  process(String s,int index,ArrayList<ArrayList<String>> res,ArrayList<String> list){
        if (index==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=index;i<s.length();i++){
            String str=s.substring(index,i+1);
            if (isPalindrome(str)){
                list.add(str);
                process(s,i+1,res,list);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        if (s.length()==1) return true;
        int low=0,high=s.length()-1;
        while (low<high){
            if (s.charAt(low)!=s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}
