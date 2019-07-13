package com.company.nowLeetCode.Few;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 9:18
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Math_isPalindrome {
    /**
     * 判断是否是回文数，使用的就是除加取余，但是在求最大的除数时候需要决定是否等于10，都要将10的情况考虑下
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x){
        if (x<0) return false;
        int help=10;
        while (x/help>=10) help*=10;
        while (x>=10){
            int m=(x/help);
            int n=(x%10);
            System.out.println(m+"=="+n);
            if (m==n) {
                x=(x%help)/10;
                help/=100;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1010101));
    }
}
