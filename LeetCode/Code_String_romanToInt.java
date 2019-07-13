package com.company.nowLeetCode.String;

/**
 * Author:   hszzjs
 * Date:     2019/2/24 12:38
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_romanToInt {
    /**
     * 首先规则：I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
     * 然后从后向前开始读，随便找一个数字判断规则。
     * @param s
     * @return
     */
    public int romanToInt(String s){
        int res=0;
        for (int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            if (c=='I'){
                if (res>=5) res-=1;//从后向前读，如果大于5，必然是先遇到得到V，所以I在左边，就减去
                else res+=1;
            }else if (c=='V') res+=5;
            else if (c=='X') {//从后向前读，大于50，必然先遇到L
                if (res>=50) res-=10;
                else res+=10;
            }else if (c=='L') res+=50;
            else if (c=='C'){//同理
                if (res>=500) res-=100;
                else res+=100;
            }else if (c=='D') res+=500;
            else if (c=='M') res+=1000;
        }
        return res;
    }
}
