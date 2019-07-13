package com.company.ForTruth.拼夕夕;

import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/15 8:13
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * 一个合法的圆括号表达式满足以下条件：
 1. “”空字符串被认为是合法的。
 2. 如果字符串“X”与“Y”是合法的，则“XY”也被认为是合法的。
 3. 如果字符串“X”是合法的，则“(X)”也是合法的。
 例如，“”，“()”，“()()”，“(())”这些都是合法的。
 现在给出两个不保证合法的由圆括号组成的字符串，你需要交错这两个圆括号序列（在组成的新字符串中，每个初始字符串都保持原来的顺序）
 得到一个新的合法的圆括号表达式（不同的交错方式可能得到相同的表达式，这种情况分开计数），
 求共有多少结果合法的交错方式（无法得到合法的圆括号表达式则输出0），输出结果对10^9+7取模后的值。
 输入格式
 输入共两行，每行包含一个由“(”和“)”组成的字符串，长度不超过2500。
 输出格式
 输出为一个数字，表示合法的交错方式数量对109+7取模后的值。
 输入样例：
 (()
 ())
 输出样例：
 19
 */
public class 括号序列 {
    private static final int mod=1000000007;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] str1=sc.nextLine().trim().toCharArray();
        char[] str2=sc.nextLine().trim().toCharArray();
        int[] cnt1=new int[str1.length+1];
        int[] cnt2=new int[str2.length+1];
        Valid(cnt1,str1);
        Valid(cnt2,str2);
        //如果两个合并后不是合法的，那就不用合并了
        if(cnt1[str1.length]+cnt2[str2.length]!=0) System.out.println(0);
        else {
            //dp(i,j)：就是第一个序列的前i个括号，与第二个序列的前j个括号，交错组成的合法括号序列个数
            int[][] dp=new int[str1.length+1][str2.length+1];
            for(int i=0;i<=str1.length;i++){
                for (int j=0;j<=str2.length;j++){
                    //初始化
                    if(i==0 && j==0) dp[i][j]=1;
                    else {
                        if(cnt1[i]+cnt2[j]>=0){
                            if(i>0) dp[i][j]+=dp[i-1][j];
                            if (j>0) dp[i][j]+=dp[i][j-1];
                            dp[i][j]%=mod;
                        }
                    }
                }
            }
            System.out.println(dp[str1.length][str2.length]);
        }
    }
    private static void Valid(int[] cnt,char[] chars){
        for(int i=0;i<chars.length;i++){
            if (chars[i] == '(') {
                cnt[i+1]=cnt[i]+1;
            }else cnt[i+1]=cnt[i]-1;
        }
    }
}
/**
 * 类型题思路总结：
 * 对于括号序列，如果将左括号看做1，右括号看做-1，那么合法序列必然满足：
 * ① 从左向右遍历过程中，和cnt>=0;
 * ② 遍历结束后，和cnt=0.
 * 然后对于合法括号序列，一般都是使用栈来进行处理，左括号入栈，遇到右括号出栈，最后判断栈是否为空
 */