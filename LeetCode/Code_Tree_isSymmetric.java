package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author:   hszzjs
 * Date:     2019/2/15 12:05
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_isSymmetric {
    public boolean isSymmetric(TreeNode root){
        /**
         * 使用了双端队列，左边从头进，右边从尾进
         */
        if (root==null || (root.left==null && root.right==null)) return true;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.addFirst(root.left);//使用add以及offer的区别就是是否会抛出异常
        deque.addLast(root.right);
        while (!deque.isEmpty()){
            TreeNode curL=deque.pollFirst();
            TreeNode curR=deque.pollLast();
            if (curL==null && curR==null) continue;
            if (curL==null ||curR==null) return false;
            if (curL.val!=curR.val) return false;
            else {
                deque.addFirst(curL.right);
                deque.addFirst(curL.left);
                deque.addLast(curR.left);
                deque.addLast(curR.right);
            }
        }
        return true;
    }

    /**
     * 使用递归的方法进行处理，这里主要是对三种baseCase确定好，都为空为true，只有一个为空就是false，值不等的时候为false。
     * 然后递归的是左子树的左结点与右子树的右结点进行比较，左子树的右结点与右子树的左结点进行比较，只有都为true才是镜像的。
     * 然后明显递归的时间复杂度较低。
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root){
        if (root==null) return true;
        return process(root.left,root.right);
    }

    public boolean process(TreeNode left,TreeNode right){
        if (left==null && right==null) return true;
        if (left==null || right==null) return false;
        if (left.val!=right.val) return false;
        return process(left.left,right.right)&& process(left.right,right.left);
    }
}
