package com.company.nowLeetCode.Select;

/**
 * Author:   hszzjs
 * Date:     2019/2/20 16:01
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_WordSearch {
    static int[] di={0,-1,0,1};
    static int[] dj={-1,0,1,0};

    /**
     * 这个题目就是使用深度优先搜索递归，而且不能重复，一个一个遍历
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board,String word){
        boolean[][] visited=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (thisWay(board,word,i,j,0,visited)) return true;
            }
        }
        return false;
    }

    public static boolean thisWay(char[][] board,String word,int i,int j,int index,boolean[][] visited){
        if (i<0 ||i>=board.length || j<0 || j>=board[0].length || visited[i][j] || board[i][j]!=word.charAt(index)) return false;
        if (index==word.length()-1) return true;
        visited[i][j]=true;
        for (int d=0;d<4;d++){
            if (thisWay(board,word,i+di[d],j+dj[d],index+1,visited)) return true;
        }
        visited[i][j]=false;
        return false;
    }

    public static void main(String[] args) {
        char[][] b=new char[][]{{'a'}};
        System.out.println(exist(b,"ab"));
    }
}
