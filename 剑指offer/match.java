package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/23 16:31
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 参考链接：https://blog.csdn.net/zjxxyz123/article/details/79840506
 */
public class match {
    /**
     * 运行时间：17ms，占用内存：9332k
     * 递归实现
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str,char[] pattern){
        if(str==null||pattern==null) return false;
        return matchCore(str,pattern,0,0);
    }
    public boolean matchCore(char[] s,char[] p,int sIndex,int pIndex){
        //p串已经用尽，如果s也已经结束，就是匹配成功，否则失败
        if(pIndex==p.length) return sIndex==s.length;
        //下一个不是*的情况，依旧是终止条件
        if(pIndex+1==p.length||p[pIndex+1]!='*'){
            return sIndex!=s.length&&(s[sIndex]==p[pIndex]||p[pIndex]=='.')&&matchCore(s,p,sIndex+1,pIndex+1);
        }
        //这里是指如果pIndex下一个元素是*，则需要考虑多个s[sIndex]与p匹配的情况
        //例如a*bb与aaaaab这种情况，i会最终停留在b的位置处
        int i=sIndex;
        while (i!=s.length&&(s[i]==p[pIndex]||p[pIndex]=='.')){
            if (matchCore(s,p,i+1,pIndex+2)) return true;
            i++;
        }
        return matchCore(s,p,sIndex,pIndex+2);
    }

    /**
     * 对于上面的递归进行优化，递归函数事实上只与sIndex以及pIndex有关，然后可以看到两者变化时从0到p.length，
     * 所以二维数组大小是（slen+1，plen+1），然后就是前面的状态与后面的状态有关，所以需要熊右下角向上遍历计算，
     * 最终的结果就是该数组的0,0位置。
     */
    public boolean match1(char[] str,char[] pattern){
        if(str==null || pattern==null) return false;
        boolean[][] dp=initDP(str,pattern);
        for(int i=str.length-1;i>=0;i--){
            for (int j=pattern.length-2;j>=0;j--){
                if (pattern[j+1]!='*'){
                    dp[i][j]=(str[i]==pattern[j] || pattern[j]=='.') && dp[i+1][j+1];
                }else {
                    int si=i;
                    while (si!=str.length && (str[si]==pattern[j] || pattern[j]=='.')){
                        if (dp[si][j+2]){
                            dp[i][j]=true;
                            break;
                        }
                        si++;
                    }
                    if (dp[i][j]!=true) dp[i][j]=dp[si][j+2];
                }
            }
        }
        return dp[0][0];
    }
    private boolean[][] initDP(char[] s,char[] p){
        int m=s.length,n=p.length;
        boolean[][] dp=new boolean[m+1][n+1];
        dp[m][n]=true;
        for(int i=n-2;i>=0;i-=2){
            if (p[i]!='*' && p[i+1]=='*'){
                dp[m][i]=true;
            }else break;
        }
        if(m>0 && n>0){
            if (p[n-1]=='.' || s[m-1]==p[n-1]){
                dp[m-1][n-1]=true;
            }
        }
        return dp;
    }
}
