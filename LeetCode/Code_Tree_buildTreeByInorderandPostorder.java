package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/14 15:22
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_buildTreeByInorderandPostorder {
    /**
     * 与上一道题相同的方法，边界抠好以后，这个就很快上手了
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder,int[] postorder){
        if (inorder.length==0 || postorder.length==0) return null;
        if (inorder==null || postorder==null) return null;
        if (inorder.length!=postorder.length) return null;
        return process(postorder,postorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode process(int[] postorder,int postIndex,int[] inorder,int inStart,int inEnd){
        TreeNode root=new TreeNode(postorder[postIndex]);
        if (inStart==inEnd) return root;
        int index=-1;
        for (int i=inStart;i<=inEnd;i++){
            if (inorder[i]==root.val) index=i;
        }
        if (inEnd>=index+1) root.right=process(postorder,postIndex-1,inorder,index+1,inEnd);
        if (index-1>=inStart) root.left=process(postorder,postIndex+index-inEnd-1,inorder,inStart,index-1);
        return root;
    }
}
