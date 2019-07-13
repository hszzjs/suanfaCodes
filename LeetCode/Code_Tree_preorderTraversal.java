package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Code_Tree_preorderTraversal {
    /**
     * 这里使用递归的方法
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderTraversal1(TreeNode root){
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        getPreOrder(res,root);
        return res;
    }
    public void getPreOrder(ArrayList<Integer> res,TreeNode root){
        if(root==null) return;
        res.add(root.val);
        getPreOrder(res,root.left);
        getPreOrder(res,root.right);
    }

    /**
     * 使用的是非递归，借用栈，相较于后序遍历，明显这个简单很多
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur=stack.pop();
            res.add(cur.val);
            if (cur.right!=null) stack.push(cur.right);
            if (cur.left!=null) stack.push(cur.left);
        }
        return res;
    }
}
