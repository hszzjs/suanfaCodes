package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

public class Code_Tree_maxPathSum {
    public static int max=0;
    /**
     * 这个依旧使用的是递归，就很挫的是，明明思路是相同的但是就是在coding的时候被拐掉了，所以就是加强coding
     * 思路依旧很不错，max修改的是left==》root==》right的值，但是当前路径的值得表示使用的是单向路径
     * @param root
     * @return
     */
    public static int maxPathSum(TreeNode root){
        if (root==null) return 0;
        getMax(root);
        return max;
    }

    public static int getMax(TreeNode root){
        int lmax=0,rmax=0;
        if (root.left!=null){
            lmax=Math.max(0,getMax(root.left));
        }
        if (root.right!=null){
            rmax=Math.max(0,getMax(root.right));
        }
        max=Math.max(max,lmax+rmax+root.val);
        return root.val+Math.max(lmax,rmax);
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
//        node.right=new TreeNode(2);
        System.out.println(maxPathSum(node));
    }
}
