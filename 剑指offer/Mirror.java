package com.company.offer;


import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2018/12/3 12:43
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：操作给定的二叉树，将其变换为源二叉树的镜像。
 * 算法思路：
 * 就看图，明显根结点不发生变化，然后交换根结点的左右结点，从上到下不断重复就可以。
 */
public class Mirror {
    /**
     * 递归，运行时间27ms，占用内存9576k
     * @param root
     */
    public void Mirror(TreeNode root){
        if(root==null) return;
        TreeNode tempNode=root.left;
        root.left=root.right;
        root.right=tempNode;

        Mirror(root.left);
        Mirror(root.right);
    }
}
