package com.company.nowLeetCode.String;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 13:06
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_lengthOfLastWord {
    /**
     * 这个提很简单，就是需要当心"   "最后出现连续空格的情况
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s){
        if (s==null || s.length()==0) return 0;
        String[] list=s.split(" ");
        ArrayList<String> arr=new ArrayList<>();
        for (String string:list){
            if (string!="") arr.add(string);
        }
        if (arr.size()==0) return 0;
        return arr.get(arr.size()-1).length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("he"));
    }
}
