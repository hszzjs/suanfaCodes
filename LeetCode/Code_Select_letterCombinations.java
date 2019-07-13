package com.company.nowLeetCode.Select;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 12:39
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_letterCombinations {
    /**
     * 就是递归，但是主要是看使用什么来存储数字与字符的对应关系，可以使用数组也可以用HashMap
     * @param digits
     * @return
     */
    public static ArrayList<String> letterCombinations(String digits){
        ArrayList<String> res=new ArrayList<>();
        if (digits==null || digits.length()==0) {
            res.add("");
            return res;
        }
        HashMap<Character,String> hashMap=new HashMap<>();
        hashMap.put('1',"");
        hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");
        String s=new String();
        process(res,s,digits,0,hashMap);
        return res;
    }

    public static void process(ArrayList<String> res,String sb,String digits,int index,HashMap<Character,String> hashMap){
        if (index==digits.length()) {
            res.add(new String(sb));
            return;
        }
        String letters=hashMap.get(digits.charAt(index));
        for (int i=0;i<letters.length();i++){
            process(res,sb+(letters.charAt(i)),digits,index+1,hashMap);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> res=letterCombinations("123");
        for (String s:res){
            System.out.println(s);
        }
    }
}
