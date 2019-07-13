package com.company.nowLeetCode.String;

/**
 * Author:   hszzjs
 * Date:     2019/2/24 13:58
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_atoi {
    /**
     * 这个做法就是使用double作为记录，最后再比较下是不是超范围，超了，返回最大小值，没超，就直接强制转化为整数
     * @param str
     * @return
     */
    public int atoi(String str){
        if (str==null || str.length()==0) return 0;
        str=str.trim();
        char zhengfu='+';
        int i=0;
        if (str.charAt(0)=='-'){
            zhengfu='-';
            i++;
        }else if (str.charAt(0)=='+') i++;
        double res=0;
        while (str.length()>i && str.charAt(i)>='0' && str.charAt(i)<='9'){
            res=res*10+str.charAt(i)-'0';
            i++;
        }
        if (zhengfu=='-'){
            res=-res;
        }
        if (res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) res;
    }

    /**
     * 这个就是使用左宗棠说的不使用类型的强制转换，只不过每次，就是判断下系统最大除以10与res的比较，然后如果相等就看对10取余的情况
     * 限制。但是左宗棠是说将所有的数取负，但是这里没有而是直接正数判断，然后使用大于号，情况满足
     * @param str
     * @return
     */
    public static int atoi1(String str){
        if (str==null || str.length()==0) return 0;
        str=str.trim();
        char zhengfu='+';
        int i=0;
        if (str.charAt(0)=='-'){
            zhengfu='-';
            i++;
        }else if (str.charAt(0)=='+') {
            i++;
        }
        int res=0;
        while (str.length()>i && str.charAt(i)>='0' && str.charAt(i)<='9'){
            if (Integer.MAX_VALUE/10<res || (Integer.MAX_VALUE/10==res && Integer.MAX_VALUE%10<(str.charAt(i)-'0'))){
                return zhengfu=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }else {
                res=res*10+str.charAt(i)-'0';
                i++;
            }
        }
        if (zhengfu=='-') res=-res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(atoi1("-2147483647"));
        System.out.println(Integer.MIN_VALUE+"&&"+Integer.MAX_VALUE);
    }
}
