package com.company.nowLeetCode.Select;

/**
 * Author:   hszzjs
 * Date:     2019/2/20 21:21
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_totalNQueens {
    int res=0;

    /**
     * 这道题就与前面一毛一样，只是返回变化而已
     * @param n
     * @return
     */
    public int totalNQueens(int n){
        if (n<=0) return 0;
        int[] jilu=new int[n];
        process(n,0,jilu);
        return res;
    }

    public void process(int n,int row,int[] jilu){
        if (n==row){ res+=1;}
        else {
            for (int i=0;i<n;i++){
                jilu[row]=i;
                if (isValid(row,jilu)) process(n,row+1,jilu);
            }
        }
    }

    public boolean isValid(int row,int[] jilu){
        for (int i=0;i<row;i++){
            if (jilu[i]==jilu[row] || Math.abs(jilu[i]-jilu[row])==row-i) return false;
        }
        return true;
    }
}
