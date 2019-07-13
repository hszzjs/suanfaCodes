package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/14 14:45
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_isBalanced {
    /**
     * 平衡二叉树的判决条件，左子树以及右子树高度差不超过1，并且左子树是平衡二叉树，右子树是平衡二叉树；
     * 所以请记住这里会需要进行两种递归，一种是判断左右子树是不是平衡二叉树，一种是获取高度。
     * 获取高度的递归，baseCase要注意该根节点下左子树的高度，以及左子树的高度都要获取，
     * 然后改根节点的高度等于左子树以及右子树高度的较大值
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root){
        if (root==null) return true;
        int RLength=getHeight(root.right);
        int LLength=getHeight(root.left);
        if (Math.abs(RLength-LLength)>1) return false;
        else {
            return isBalanced(root.right) && isBalanced(root.left);
        }
    }

    public int getHeight(TreeNode root){
        if (root==null) return 0;
        if (root.left==null && root.right==null) return 1;
        int RLength=getHeight(root.right);
        int LLength=getHeight(root.left);
        return 1+(RLength>LLength?RLength:LLength);//佛了，请记得加括号，北鼻
    }
}
