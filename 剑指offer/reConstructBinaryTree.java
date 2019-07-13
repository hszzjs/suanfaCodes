package com.company.offer;


import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2018/11/27 8:35
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 参考链接：https://blog.csdn.net/qq_21815981/article/details/79853556
 */
public class reConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        if(startPre>endPre || startIn>endIn) return null;//先证明输入是没有问题的
        TreeNode root=new TreeNode(pre[startPre]);
        for(int i=startIn;i<=endIn;i++){
            if(in[i]==pre[startPre]){//中序遍历这里的参数很好理解，但是前序遍历这里的情况是不断确定根结点，并不能很直观得到左右子树
                //关于前序遍历参数解释：首先i-startIn表示当前根节点下，左子树的结点数目，然后startPre加上i-startIn就是表示前序遍历
                // 中当前结点的左子树中的所有数目。
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }
}
