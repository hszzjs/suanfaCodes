package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:   hszzjs
 * Date:     2019/2/14 15:34
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_levelOrder {
    /**
     * 树的按层输出，使用队列，由于要每层每层的输出就使用两个变量表示当前层以及下一层的size。
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        ArrayList<Integer> r=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        int curSize=1,nextSize=0;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            r.add(cur.val);
            curSize--;
            if (cur.left!=null) {
                queue.offer(cur.left);
                nextSize++;
            }
            if (cur.right!=null) {
                queue.offer(cur.right);
                nextSize++;
            }
            if (curSize==0){
                res.add(r);
                r=new ArrayList<>();
                curSize=nextSize;
                nextSize=0;
            }
        }
        return res;
    }
}
