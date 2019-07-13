package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/19 10:30
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class LeftRotateString {
    /**
     * 运行时间：22ms，占用内存：9780k
     * 这里直接是使用了StringBuffer这类的数据结构，一个装前进的，一个装溢出的，然后两个合并就可以
     * @param str
     * @param n
     * @return
     */
    /**
    public String LeftRotateString(String str,int n){
        if (str==null || str.length()==0) return "";
        StringBuilder sb1=new StringBuilder(str.substring(0,n));
        StringBuilder sb2=new StringBuilder(str.substring(n,str.length()));
        sb2.append(sb1);
        return sb2.toString();
    }
     */
    /**
     * 运行时间34ms，占用内存9596k
     * 参考链接：https://blog.csdn.net/snow_7/article/details/52212670
     * 算法思路：
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n){
        if(str==null||str.length()<2||str.length()<=n) return str;
        char[] chars=str.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,str.length()-1);
        reverse(chars,0,chars.length-1);
        return String.valueOf(chars);
    }
    private void reverse(char[] chars,int start,int end){
        char tmp=' ';
        while (start<end){
            tmp=chars[start];
            chars[start++]=chars[end];
            chars[end--]=tmp;
        }
    }
}
