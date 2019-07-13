package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2019/2/14 15:32
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 非递归方法很重要要看的
 */
public class Code_Tree_inorderTraversal {
    /**
     * 中序遍历，就直接递归。可是如果不使用递归嘞？那就使用队列试试
     * @param root
     * @return
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        process(res,root);
        return res;
    }

    public void process(ArrayList<Integer> res, TreeNode root){
        if (root==null) return;
        process(res,root.left);
        res.add(root.val);
        process(res,root.right);
    }

    /**
     * 使用栈来进行递归替代，这里面边界很难抠，中序遍历很麻烦，不知道怎么搞左右子树，
     * 这里使用了一个指针来指当前结点，仔细想当搞根节点的左子树之后，栈中的根节点弹出，会出现右子树还没搞，
     * 但是栈已经空了。所以还需要在while中加一个判决条件cur！=null。对于栈的放入，先放左结点，直到结束，
     * 此时cur指向null，那么就开始弹出栈，弹出作为cur，将该cur看做根节点，那么，就需要写值，然后就是该根节点的右子树，
     * 右子树看要不要放入栈，不要就继续弹出。
     * @param root
     * @return
     */
    public ArrayList<Integer> inorderTraversal1(TreeNode root){
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null || !stack.isEmpty()){
            if (cur!=null) {
                stack.add(cur);
                cur=cur.left;
            }
            else {
                cur=stack.pop();
                res.add(cur.val);
                cur=cur.right;
            }
        }
        return res;
    }
}
