package com.company.nowLeetCode.String;

/**
 * Author:   hszzjs
 * Date:     2019/2/24 15:05
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_longestPalindrome {
    /**
     * 这个最长字串，是选择了从头到尾遍历，每次遍历的位置作为回文子串的中心，由于回文字串可能是偶数也可能是奇数，所以
     * 需要有两个，奇数中心为同一个，偶数中心为两个，然后回文判断函数，判断出从中心出发，字串的开始于结束位置
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        if (s==null ||s.length()<2) return s;
        String longest=s.substring(0,1);
        for (int i=0;i<s.length();i++){//i作为字串中心位置，向两边扩
            String tmp=process(s,i,i);//字串为奇数情况
            if (tmp.length()>longest.length())
                longest=tmp;
            tmp=process(s,i,i+1);//字串为偶数情况
            if (tmp.length()>longest.length())
                longest=tmp;
        }
        return longest;
    }

    public String process(String s,int begin,int end){
        while (begin>=0 && end<s.length() && s.charAt(begin)==s.charAt(end)){
            begin--;
            end++;
        }
        return s.substring(begin+1,end);
    }
}
