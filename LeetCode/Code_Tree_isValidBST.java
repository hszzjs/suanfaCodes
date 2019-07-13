package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/15 15:59
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_isValidBST {
    /**
     * 这个是错误的，没有考虑到二叉搜索树里面左子树的所有值小于根节点，右子树的所有值大于根节点
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root){
        if (root==null) return true;
        if (root.left!=null && root.left.val>=root.val){
            return false;
        }
        if (root.right!=null && root.right.val<=root.val){
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    /**
     * 这是正儿八经的递归，每次讲最大值最小值传递进去进行比较，进行约束
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root){
        if (root==null) return true;
        return process(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean process(TreeNode root,int low,int high){
        if (root==null) return true;
        if (root.val<=low || root.val>=high) return false;
        return process(root.left,low,root.val) && process(root.right,root.val,high);
    }
}
