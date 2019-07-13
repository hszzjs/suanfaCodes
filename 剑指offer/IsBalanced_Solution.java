package com.company.offer;


import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2018/12/18 15:50
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 说明：
 * 平衡二叉树是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 */
public class IsBalanced_Solution {
    private boolean isBalanced = false;
    /**
     * 运行时间19ms，占用内存9388k
     * @param root
     * @return
     */
    /**
    public boolean IsBalanced_Solution(TreeNode root){
        getDepth(root);
        return isBalanced;
    }
    public int getDepth(TreeNode root) {
        if (root == null) {
            isBalanced = true;
            return 0;
        }
        int left = getDepth(root.left);//左子树
        int right = getDepth(root.right);//右子树
        int depth = (left > right ? left : right) + 1;
        if (Math.abs(left - right) <= 1) {
            isBalanced = true;
        } else {
            isBalanced = false;
        }
        return depth;
    }
     */

    /**
     * 自己的方法，就是根据定义，时间内存上没有多大区别
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null) return true;
        TreeNode l=root.left;
        TreeNode r=root.right;
        if(Math.abs(getDepth(l)-getDepth(r))<=1) return true;
        return false;
    }
    private int getDepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}
