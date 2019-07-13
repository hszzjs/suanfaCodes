package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 13:02
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_SurroundedRegions {
    /**
     * 这个很挫，等明天早上看看
     * @param grid
     */
    public void solve(char[][] grid) {
        if (grid == null)
            return;
        int rows = grid.length;
        if (rows <= 0)
            return;
        int cols = grid[0].length;
        if (cols <= 0)
            return;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 'O')
                dfsSearch(grid, i, 0);
            if (grid[i][cols - 1] == 'O')
                dfsSearch(grid, i, cols - 1);
        }
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 'O')
                dfsSearch(grid, 0, i);
            if (grid[rows - 1][i] == 'O')
                dfsSearch(grid, rows - 1, i);
        }

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == '*')
                    grid[i][j] = 'O';
                else if (grid[i][j] == 'O')
                    grid[i][j] = 'X';
    }

    // 每遇到'O'后, 开始向四个方向 递归搜索. 搜到后变为'*',
    // 因为相邻的属于一个island. 然后开始继续找下一个'O'.
    private void dfsSearch(char[][] grid, int i, int j) {
        if (grid[i][j] == 'O') {
            // 修改为一个不相干的字符，但不能是X
            grid[i][j] = '*';// 和visited数组一样功能
            // 不需要处理四周边缘了，调用循环已经处理过，不然超时
            if (i < grid.length - 2)
                dfsSearch(grid, i + 1, j);
            if (i > 1)
                dfsSearch(grid, i - 1, j);
            if (j < grid[0].length - 2)
                dfsSearch(grid, i, j + 1);
            if (j > 1)
                dfsSearch(grid, i, j - 1);
        }
    }

}
