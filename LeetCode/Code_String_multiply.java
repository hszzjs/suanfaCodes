package com.company.nowLeetCode.String;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 20:41
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_multiply {
    /**
     * 这道题的做法很实在，就是首先每次都有溢出，所以就模拟乘法的过程，使用数组来存储每位生成数，
     * 首先一个数长度为m，一个数为n那么生成数的长度就是m+n-1，但是为了防止溢出使用m+n的数组来存储，
     * 由于字符串是由左向右，数的惩罚是从又向左，所以将两个数反转，开始相乘，num1的第i个数与num2的第j个数相乘，
     * 生成数的位置应该在第i+j位。乘法完毕后考虑到是十进制，所以本位对10取余，进位是除以10.搞完就可以开始转字符串了，
     * 但是考虑可能数组长度为0，然后首位没有溢出，需要特殊处理。
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1,String num2){
        num1=new StringBuilder(num1).reverse().toString();
        num2=new StringBuilder(num2).reverse().toString();
        int[] d=new int[num1.length()+num2.length()];
        for (int i=0;i<num1.length();i++){
            int a=num1.charAt(i)-'0';
            for (int j=0;j<num2.length();j++){
                int b=num2.charAt(j)-'0';
                d[i+j]+=a*b;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<d.length;i++){
            int digit=d[i]%10;
            int jinwei=d[i]/10;
            sb.insert(0,digit);
            if (i<d.length-1){
                d[i+1]+=jinwei;
            }
        }
        while (sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.length()==0?"0":sb.toString();
    }
}
