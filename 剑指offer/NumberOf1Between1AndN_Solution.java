package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/16 10:50
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class NumberOf1Between1AndN_Solution {
    /**
     * 运行时间26ms，占用内存9040k
     * 参考链接：https://www.cnblogs.com/xuanxufeng/p/6854105.html
     * @param n
     * @return
     */
    /**
    public int NumberOf1Between1AndN_Solution(int n){
        int res=0;
        for(long m=1;m<=n;m*=10)
            res+=(n/m+8)/10*m+(n/m%10==1?n%m+1:0);
        return res;
    }*/
    /**
     * 运行时间18ms，占用内存9264k
     * 参考链接：http://www.cnblogs.com/yongh/p/9947165.html
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n){
        int cnt=0;
        for(int i=1;i<=n;i*=10){
            int high=n/(i*10);
            int low=(n%i);
            int cur=(n/i)%10;
            if(cur==0) cnt+=high*i;
            else if (cur==1) cnt+=high*i+(low+1);
            else cnt+=(high+1)*i;
        }
        return cnt;
    }
}
