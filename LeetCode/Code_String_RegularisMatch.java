package com.company.nowLeetCode.String;

/**
 * Author:   hszzjs
 * Date:     2019/2/24 13:24
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_RegularisMatch {
    /**
     * 首先对着个题意解释，*代表的是它前面的元素是0个或者多个，所以每次*都是与它前面的元素一起看的。
     * 然后这里使用的是递归，递归的终止basecase就是p.length=0，那么就要看s.length是不是为0，如果p.length=1，就是要求
     * s.length=1并且，最后这个字符是可以匹配的。然后p的长度就是大于等于2了，由于*与前面的元素一起出现，需要判断先p.charAt(1)是不是*，
     * 不是，如果s.length为0，就不用匹配了，不为0，首先第一个元素是要可以匹配的，然后就是第一个元素之后的所有元素是不是匹配的，就是递归，
     * 如果是*，依旧先假设代表的是前面那个元素为0，那么由*之后的字符串与当前s匹配，匹配上了就返回true（递归），每匹配上，那么
     * 便是表示元素个数为1，匹配下这个元素，匹配上了，依旧p是由*之后的字符串于s匹配上了之后的元素进行匹配（递归）。
     * 这个代码已经优化的很不错了，学习
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s,String p){
        if (p.length()==0) return s.length()==0;
        if (p.length()==1)
            return (s.length()==1) && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.');
        if (p.charAt(1)!='*'){
            if (s.length()==0) return false;
            else return (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.') && isMatch(s.substring(1),p.substring(1));
        }else {
            while (s.length()>0 && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.')){
                if (isMatch(s,p.substring(2))) return true;
                s=s.substring(1);
            }
            return isMatch(s,p.substring(2));
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab","a*a*b"));
    }
}
