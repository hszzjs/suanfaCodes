package com.company.nowLeetCode.Select;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2019/2/20 20:16
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_solveNQueens {
    /**
     * 首先说明queen可以上下左右斜着走，所以queen只有作为九宫格的中心才不会彼此袭击。
     * 然后由于不确定怎么走，所以需要起始位置遍历然后递归得到所有的放置方法。为了记录每次走放的位置，这里使用了一维数组，
     * 一维数组的索引表示行，值表示列，然后还有一点很恰好就是基本上棋盘一行只能放一个queen。所以使用一维数组表示很合适。
     * 一旦所有行放满，那就需要按照他们所说的格式进行转化放入。
     * @param n
     * @return
     */
    public ArrayList<String[]> solveNQueens(int n){
        ArrayList<String[]> res=new ArrayList<>();
        if (n<=0) return res;
        int[] colnumVal=new int[n];
        DFS_helper(n,res,0,colnumVal);
        return res;
    }

    public void DFS_helper(int n,ArrayList<String[]> res,int row,int[] colnumVal){
        if (row==n){
            String[] unit=new String[n];
            for (int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for (int j=0;j<n;j++){
                    if (j==colnumVal[i]) sb.append("Q");
                    else sb.append(".");
                }
                unit[i]=sb.toString();
            }
            res.add(unit);
        }else {
            for (int i=0;i<n;i++){
                colnumVal[row]=i;
                if (isValid(row,colnumVal)){
                    DFS_helper(n,res,row+1,colnumVal);
                }
            }
        }
    }

    public boolean isValid(int row,int[] colnumVal){
        for (int i=0;i<row;i++){//这个是表示不在同一行，并且彼此也不在对角线上
            if (colnumVal[row]==colnumVal[i] || Math.abs(colnumVal[row]-colnumVal[i])==row-i){
                return false;
            }
        }
        return true;
    }
}
