package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/21 20:50
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：把字符串转换成整数
 * 算法思路：就是首先检查符号位，接着就是
 */
public class StrToInt {
    /**
     * 运行时间21ms，占用内存9400k
     * 参考链接：https://blog.csdn.net/weixin_41835916/article/details/80818314
     * @param str
     * @return
     */
    /**
    public int StrToInt(String str){
        if(str.equals("") || str.length()==0) return 0;
        char[] a=str.toCharArray();
        int i=0;
        boolean fuhao=true;
        if(a[0]=='-'){
            fuhao=false;
            i=1;
        }
        int sum=0;
        for(;i<a.length;i++){
            if(a[i]=='+') continue;
            if (a[i]<48 || a[i]>57) return 0;
            sum=sum*10+a[i]-48;
            if((fuhao&&sum>0X7fffffff)||(!fuhao&&sum<0X80000000)){
                sum=0;
                break;
            }
        }
        return fuhao?sum:sum*-1;
    }
     */
    /**
     * 运行时间16ms，占用内存9328k
     * 参考链接：https://blog.csdn.net/yangxingpa/article/details/79900732
     * @param str
     * @return
     */
    public int StrToInt(String str){
        if(str.equals("")||str.length()==0) return 0;
        int sum=0;
        int fuhao=1;
        if(str.toCharArray()[0]=='-'){
            str=str.substring(1,str.length());
            fuhao=-1;
        }else if (str.charAt(0)=='+'){
            str=str.substring(1,str.length());
        }
        char[] a=str.toCharArray();
        for (int i=0;i<a.length;i++){
            if (a[i]<48 || a[i]>57)
                return 0;
            sum=sum*10+a[i]-48;
        }
        sum=sum*fuhao;
        return sum;
    }
}
