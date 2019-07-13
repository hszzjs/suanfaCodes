package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2019/2/14 14:01
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_Code_Tree_hasPathSumII {
    /**
     * 这道题的递归理解很简单，但是难点在于扣边界，最终决策，要注意就是如果该路径到底一直都不等于和呢？
     * 那就需要将它们在最后remove掉爱。
     * 按照这里这里的理解，找到的路径是由root到最后的一个结点路径和为sum。
     * @param root
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root,int sum){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> res2=new ArrayList<>();
        process(res,root,sum,res2);
        return res;
    }

    public void process(ArrayList<ArrayList<Integer>> res, TreeNode root,int curSum,ArrayList<Integer> res2){
        if (root==null) return;
        res2.add(root.val);
        curSum-=root.val;
        if (root.left==null && root.right==null){
            if (curSum==0){
                res.add(new ArrayList<>(res2));
            }
        }else {
            if (root.left!=null) process(res,root.left,curSum,res2);
            if (root.right!=null) process(res,root.right,curSum,res2);
        }
        res2.remove(res2.size()-1);//这个极为重要
    }
}
