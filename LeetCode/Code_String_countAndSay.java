package com.company.nowLeetCode.String;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 21:02
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_countAndSay {
    /**
     * 说明下题意：输入n，那么我就打出第n行的字符串。
     * n = 1时，打印一个1。
     * n = 2时，看n=1那一行，念：1个1，所以打印：11。
     * n = 3时，看n=2那一行，念：2个1，所以打印：21。
     * n = 4时，看n=3那一行，念：一个2一个1，所以打印：1211。
     * 这里有一个比较麻烦的边界条件就是，如果最后一个字符与前一个相等了，就会只计数，而没有添加到sb里面，
     * 所以索性就直接从第一个开始比较，一直到倒数第二个，但是他会与最后一个比较相不相同，所以计数君就是最后一个的个数，
     * 循环结束吧最后一个记得添加就好
     * @param n
     * @return
     */
    public String countAndSay(int n){
        if (n<=0) return "";
        String base="1";
        int start=1;
        while (start<n){
            StringBuilder res=new StringBuilder();
            int cnt=1;
            for (int j=0;j<base.length()-1;j++){
                if (base.charAt(j)==base.charAt(j+1))
                    cnt++;
                else {
                    res.append(cnt);
                    res.append(base.charAt(j));
                    cnt=1;
                }
            }
            res.append(cnt);
            res.append(base.charAt(base.length()-1));
            base=res.toString();
            start++;
        }
        return base;
    }
}
