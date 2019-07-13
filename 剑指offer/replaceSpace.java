package com.company.offer;


/**
 * Author:   hszzjs
 * Date:     2018/11/26 22:43
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 参考链接：https://blog.csdn.net/u012162920/article/details/52213007
 * 说明：
 * 有两种情况，一种是在原有的字符串上进行修改，一种是新建一个字符串进行修改，
 * 这里说明使用本地的方法就是在原有的字符串上面修改
 */
public class replaceSpace {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll("\\s","%20");
    }

    public String replaceSpaceOr(StringBuffer str){
        int length=str.length()-1;
        int numBlank=0;
        for(char c:str.toString().toCharArray()){
            if(c==' ') numBlank++;
        }//其实这里的理解主要是长度
        int newLength=length+numBlank*2+1;
        str.setLength(newLength);
        newLength=newLength-1;
        while (length>=0 && newLength>length){
            if (str.charAt(length)==' '){
                str.setCharAt(newLength--,'0');
                str.setCharAt(newLength--,'2');
                str.setCharAt(newLength--,'%');
            }else str.setCharAt(newLength--,str.charAt(length));
            length--;
        }
        return str.toString();
    }
}
