package com.company.ForTruth.zijietiaodong;

import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2019/7/4 20:24
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 首先最近父节点，根据树的结构明显可以看到两个结点必然是存在于该结点的两侧，
 * 假设在单侧那么必然是最近父节点，要么是其中某个结点，要么就是这个结点的父节点
 * 默认是可以使用该结点
 * 再利用二叉搜索树的特性就可以
 */
public class 二叉搜索树的公共父节点 {
    public TreeNode findFather(TreeNode root,TreeNode node1,TreeNode node2){
        if(node1==null || node2==null || root==null) return null;
        TreeNode res=new TreeNode(Integer.MAX_VALUE);
        if (node1.val<root.val && node2.val<root.val){
            findFather(root.left,node1,node2);
        }else if (node1.val>root.val && node2.val>root.val){
            findFather(root.right,node1,node2);
        }else res=root;
        return res;
    }
}
