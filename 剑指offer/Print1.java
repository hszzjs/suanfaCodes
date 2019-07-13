package com.company.offer;

import com.company.basicStructrue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:   hszzjs
 * Date:     2018/12/26 15:37
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：把二叉树打印成多行
 */
public class Print1 {
    /**
     * 运行时间27ms，占用内存：9688k
     * 算法思路：就参考之字形
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (pRoot==null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        int start=0,end=1;
        ArrayList<Integer> list=new ArrayList<>();
        q.add(pRoot);
        while (!q.isEmpty()){
            TreeNode cur=q.remove();
            list.add(cur.val);
            start++;
            if(cur.left!=null) q.add(cur.left);
            if (cur.right!=null) q.add(cur.right);
            if(start==end){
                start=0;
                end=q.size();
                res.add(list);
                list=new ArrayList<>();
            }
        }
        return res;
    }
}
