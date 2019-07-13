package com.company.nowLeetCode.Select;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 9:26
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_sudokusolver {
    public void solveSudoku(char[][] board){
        if (board==null || board.length==0) return;
        process(board);
    }

    public boolean process(char[][] board){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='.'){
                    for (char c='1';c<='9';c++){
                        if (isValid(board,i,j,c)){
                            board[i][j]=c;
                            if (process(board)) return true;
                            else board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c){
        // check column
        for (int row=0; row<9; row++)
            if (board[row][j] == c)
                return false;

        // check row
        for (int col=0; col<9; col++)
            if (board[i][col]==c)
                return false;

        // check block
        for(int row=i/3*3; row<i/3*3+3; row++)
            for (int col=j/3*3; col<j/3*3+3; col++)
                if (board[row][col]==c)
                    return false;

        return true;
    }
}
