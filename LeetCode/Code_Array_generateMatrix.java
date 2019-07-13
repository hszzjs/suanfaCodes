package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/22 9:37
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_generateMatrix {
    /**
     * 这个题的重点是使用这种指针。一定要熟悉。
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n){
        int[][] res=new int[n][n];
        int x=0,y=0,cnt=1;
        while (n>0){
            if (n==1){
                res[x][y]=cnt;
                break;
            }
            for (int i=0;i<n-1;i++){
                res[x][y++]=cnt++;
            }
            for (int i=0;i<n-1;i++){
                res[x++][y]=cnt++;
            }
            for (int i=0;i<n-1;i++){
                res[x][y--]=cnt++;
            }
            for (int i=0;i<n-1;i++){
                res[x--][y]=cnt++;
            }
            x++;
            y++;
            n-=2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res=generateMatrix(4);
        for (int i=0;i<res.length;i++){
            System.out.println();
            for (int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]);
            }
        }
    }
}
