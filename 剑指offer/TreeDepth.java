package com.company.offer;


import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2018/12/18 15:42
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class TreeDepth {
    /**
     * 运行时间16ms，占用内存9344k
     * 算法思路：就是不同递归寻找左右子树中最长的那个
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }
}
