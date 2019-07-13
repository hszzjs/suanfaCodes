package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/24 8:40
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：表示数值的字符串
 * 参考链接：https://blog.csdn.net/qq_23031939/article/details/82223359
 */
public class isNumeric {
    /**
     * 运行时间23ms，占用内存9568k
     * 算法思路：采用正则表达式判断字符串是否可以表示数值
     * @param str
     * @return
     */
    public boolean isNumeric1(char[] str){
        String string=String.valueOf(str);
        return string.matches("[\\+\\-]?[0-9]*(\\.[0-9]*)?([eE][\\+\\-]?[0-9]+)?");
    }

    /**
     * 运行时间21ms，占用内存9288k
     * 算法思路：采用异常捕获机制判断是否可以转换为double类型
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str){
        try {
            Double.valueOf(new String(str));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
