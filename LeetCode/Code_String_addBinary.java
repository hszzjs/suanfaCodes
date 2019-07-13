package com.company.nowLeetCode.String;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 13:34
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_addBinary {
    /**
     * 二进制相加，这个做法简直不能够更简单了，就是两个数组，分别从后向前相加，加出来的结果对2取余就是当前位的结果，
     * 除以2就是溢出结果，将当前的结果使用StringBuilder添加，到最后就是直接使用StringBuilder的翻转函数就可以
     * 最后要对溢出位判断下
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a,String b){
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int jinwei=0;
        while (i>=0 || j>=0){
            int sum=jinwei;
            if (j>=0){
                sum+=b.charAt(j--)-'0';
            }
            if (i>=0){
                sum+=a.charAt(i--)-'0';
            }
            sb.append(sum%2);
            jinwei=sum/2;
        }
        if (jinwei!=0) sb.append(jinwei);
        return sb.reverse().toString();
    }
}
