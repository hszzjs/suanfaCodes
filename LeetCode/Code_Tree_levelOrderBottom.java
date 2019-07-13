package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2019/2/14 16:50
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_levelOrderBottom {
    /**
     * 增加了一个要求就是逆序输出，那就使用一个栈
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        ArrayList<Integer> r=new ArrayList<>();
        int curSize=1,nextSize=0;
        Queue<TreeNode> queue=new LinkedList<>();
        Stack<ArrayList<Integer>> stack=new Stack<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            r.add(cur.val);
            curSize--;
            if (cur.left!=null){
                queue.offer(cur.left);
                nextSize++;
            }
            if (cur.right!=null){
                queue.offer(cur.right);
                nextSize++;
            }
            if (curSize==0){
                stack.add(r);
                curSize=nextSize;
                nextSize=0;
                r=new ArrayList<>();
            }
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
