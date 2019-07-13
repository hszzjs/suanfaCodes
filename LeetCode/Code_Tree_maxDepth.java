package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

import javax.print.attribute.standard.NumberUp;

/**
 * Author:   hszzjs
 * Date:     2019/2/15 10:53
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_maxDepth {
    /**
     * 这个就是直接使用递归，挫的是请记住全局变量，都是直接使用的
     */
    public int max=Integer.MIN_VALUE;
    public int maxDepth(TreeNode root){
        if (root==null) return 0;
        getLength(root,1);
        return max;
    }
    public void getLength(TreeNode root,int L){
        if (root.left==null && root.right==null){
            max=Math.max(max,L);
        }
        if (root.left!= null) getLength(root.left,L+1);
        if (root.right!=null) getLength(root.right,L+1);
    }
}
