package com.company.offer;


import com.company.basicStructrue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:   hszzjs
 * Date:     2018/12/3 19:29
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 算法思路：
 * 这里主要是使用Queue先进先出的特性来储存根结点，这样就可以完成从上到下从左到右打印了，知道queue中所有结点弹出
 * 参考链接：https://blog.csdn.net/u012270113/article/details/47377843?utm_source=blogxgwz2
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        ArrayList<Integer> out=new ArrayList<>();
        Queue<TreeNode> node=new LinkedList<>();
        if (root==null) return out;
        out.add(root.val);
        node.add(root);
        while (node.size()!=0){
            root=node.poll();
            if(root.left!=null){
                out.add(root.left.val);
                node.add(root.left);
            }
            if(root.right!=null){
                out.add(root.right.val);
                node.add(root.right);
            }
        }
        return out;
    }
}
