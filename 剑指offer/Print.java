package com.company.offer;


import com.company.basicStructrue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:   hszzjs
 * Date:     2018/12/26 14:57
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：按之字形顺序打印二叉树
 * 参考链接：https://blog.csdn.net/ouyangyanlan/article/details/72878992
 */
public class Print {
    /**
     * 运行时间：24ms，占用内存：9612k
     * 算法思路：这里输出单元ArrayList就指的是按照每两个结点算的，然后用了一个队列，放入该层的所有结点。
     * 用每层的结点数判断是否该层已经结束。
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (pRoot==null) return res;
        boolean left2right=true;
        Queue<TreeNode> layer=new LinkedList<>();
        ArrayList<Integer> layerList=new ArrayList<>();
        layer.add(pRoot);
        int start=0,end=1;
        while (!layer.isEmpty()){
            TreeNode cur=layer.remove();
            if (left2right) layerList.add(cur.val);
            else layerList.add(0,cur.val);
            start++;
            if (cur.left!=null) layer.add(cur.left);
            if (cur.right!=null) layer.add(cur.right);
            if(start==end){
                end=layer.size();
                start=0;
                res.add(layerList);
                left2right=!left2right;
                layerList=new ArrayList<Integer>();
            }
        }
        return res;
    }
}
