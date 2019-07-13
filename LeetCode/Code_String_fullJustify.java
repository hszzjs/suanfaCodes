package com.company.nowLeetCode.String;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 19:12
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_fullJustify {
    /**
     * 这种屎一样的题存在的意义是什么？膈应人吗？
     * 参考链接：https://www.cnblogs.com/springfor/p/3896168.html
     * @param words
     * @param L
     * @return
     */
    public ArrayList<String> fullJustify(String[] words,int L){
        ArrayList<String> res=new ArrayList<>();
        if (words==null || words.length==0) return res;
        int cnt=0,last=0;
        for (int i=0;i<words.length;i++){
            if (cnt+words[i].length()+(i-last)>L){
                int spaceNum=0;
                int extraNum=0;
                if (i-last-1>0){
                    spaceNum=(L-cnt)/(i-last-1);
                    extraNum=(L-cnt)%(i-last-1);
                }
                StringBuilder sb=new StringBuilder();
                for (int j=last;j<i;j++){
                    sb.append(words[j]);
                    if (j<i-1){
                        for (int k=0;k<spaceNum;k++){
                            sb.append(" ");
                        }
                        if (extraNum>0)
                            sb.append(" ");
                        extraNum--;
                    }
                }
                for (int j=sb.length();j<L;j++)
                    sb.append(" ");
                res.add(sb.toString());
                cnt=0;
                last=i;
            }
            cnt+=words[i].length();
        }
        StringBuilder sb=new StringBuilder();
        for (int i=last;i<words.length;i++){
            sb.append(words[i]);
            if (sb.length()<L){
                sb.append(" ");
            }
        }
        for (int i=sb.length();i<L;i++){
            sb.append(" ");
        }
        res.add(sb.toString());
        return res;
    }
}
