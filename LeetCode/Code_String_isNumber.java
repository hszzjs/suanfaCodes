package com.company.nowLeetCode.String;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 18:58
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_isNumber {
    /**
     * 这道题在我看来纯粹很扯，完全是在判断是否考虑到每一种有效情况。佛了。
     * 参考链接：https://www.cnblogs.com/grandyang/p/4084408.html
     * https://blog.csdn.net/evan123mg/article/details/46923933
     * https://blog.csdn.net/agvjh/article/details/78596134
     * 小莹子用的正则变大是，表示看不懂，也不想看懂
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if(s.trim().isEmpty()){
            return false;
        }
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        if(s.trim().matches(regex)){
            return true;
        }else{
            return false;
        }
    }
}
