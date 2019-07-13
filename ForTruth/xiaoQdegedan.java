package com.company.ForTruth.Tencent;

import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/4/12 8:51
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class xiaoQdegedan {
    /**
     * Approach：DP
     * 只有两种长度的歌曲，且方案数与顺序无关，很明显就是使用C(m,n)计算
     * 因此问题就是如何高效地输出C(m,n)
     * 这里使用数学归纳法，即C(n,k) = C(n-1,k) + C(n-1,k-1）
     * 因此实际上是对应于杨辉三角：
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     * ...........
     *
     * 我们只需要构造出需要的杨辉三角，然后直接取出需要的值计算即可。
     */
    public static final int MOD=1000000007;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int K=sc.nextInt();
            int A=sc.nextInt(),X=sc.nextInt();
            int B=sc.nextInt(),Y=sc.nextInt();
            System.out.println(process(K,A,X,B,Y));
        }
        sc.close();
    }

    public static int process(int K,int A,int X,int B,int Y){
        long[][] tri=new long[105][105];
        tri[0][0]=1;
        for (int i=1;i<105;i++){
            tri[i][0]=1;
            for (int j=1;j<105;j++){
                tri[i][j]=(tri[i-1][j-1]+tri[i-1][j])%MOD;
            }
        }

        long rst=0;
        for(int i=0;i<=X;i++){
            int left=K-A*i;
            if(left>=0 && left%B==0 && left/B<=Y){
                rst=(rst+tri[X][i]*tri[Y][left/B]%MOD);
            }
        }
        return (int)rst;
    }
}
