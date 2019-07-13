package com.company.nowLeetCode.String;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 14:25
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_wildcardisMatch {
    /**
     * 这个是使用动态规划。佛了。我决定先使用递归的方法。
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s,String p){
        int m=s.length(),n=p.length();
        char[] sc=s.toCharArray();
        char[] pc=p.toCharArray();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for (int j=1;j<n+1;j++){
            if (pc[j-1]=='*') dp[0][j]=dp[0][j-1];
        }
        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                if (pc[j-1]==sc[i-1] || pc[j-1]=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if (pc[j-1]=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }else {
                    dp[i][j]=false;
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 这个方法才是正规的做法，就是双指针开始匹配，匹配到了就同时前进，没有匹配到，那么就看p上j指向的是不是“*”，
     * 不指向那就必然false，但是指向的话，那么就意味当时这个*就可以匹配到s后面所有的字符串了，但是避免*后面还有字符，这样子，
     * start初始是-1，start针对的是j，match针对i，赋值，先认为*为空去继续匹配i与j++，一旦不匹配，看start是不是-1，
     * 不是-1说明前面有*，那么久认为是*将这个不匹配的吃掉了，所以j=start+1，i就是match的下一个，如果是满足的，走着走着发现又不等了，
     * 再判断下start等不等于-1，不等于，那么就是前面的*抵掉了它到不匹配的这个地方，那么i需要重新开始也就是match这里，
     * 这是因为这次将*看做是抵掉两个，样子不断去尝试，总会到抵掉不满足的
     * 当s匹配完了，p却还有，只要他后面不是全都是*，那就是false
     * 参考链接：
     * https://shmilyaw-hotmail-com.iteye.com/blog/2154716
     * https://blog.csdn.net/Lynn_Baby/article/details/80760300
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s,String p){
        int i=0,j=0;//两个字符串分别安排一个指针从头开始匹配
        int start=-1;//为了预防碰到“*”，使用标记
        int match=-1;
        while (i<s.length()){
            if (j<p.length() && (p.charAt(j)==s.charAt(i) || p.charAt(j)=='?')){
                i++;
                j++;
            }else if (j<p.length() && p.charAt(j)=='*'){
                start=j++;
                match=i;
            }else if (start!=-1){
                j=start+1;
                i=++match;
            }else return false;
        }
        while (j<p.length() && p.charAt(j)=='*'){
            ++j;
        }
        return j==p.length();
    }
}
