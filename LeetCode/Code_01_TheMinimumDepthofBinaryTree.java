package com.company.nowLeetCode;

import com.company.basicStructrue.TreeNode;

public class Code_01_TheMinimumDepthofBinaryTree {
    /**
     * 这个题是求二叉树的最小高度，首先题目中已经说明最小高度就是最短的那条路径，所以使用递归，
     * 但是直接使用递归需要注意的一点就是节点的两个子节点其中一个为空，是要继续计算不为空节点的路径，
     * 所以需要注意边界条件
     * @param root
     * @return
     */
    public int run(TreeNode root){
        if (root==null) return 0;
        int resL=run(root.left)+1;
        int resR=run(root.right)+1;
        if ((resL==1&&resR!=1)||(resR==1&&resL!=1)) return Math.max(resL,resR);
        return Math.min(resL,resR);
    }
}
