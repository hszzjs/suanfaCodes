package com.company.offer;


import com.company.basicStructrue.TreeNode;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2018/12/4 13:30
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * 算法思路：
 * 递归先序遍历树，把结点加入路径，若该结点是叶子结点则比较当前路径和是否等于期待和，
 * 弹出结点，每一轮递归返回到父节点，当前路径也应该回退一个结点
 * 参考链接：https://www.cnblogs.com/lfeng1205/p/6853918.html?utm_source=itdadao&utm_medium=referral
 */
public class FindPath {
    ArrayList<Integer> list=new ArrayList<>();
    ArrayList<ArrayList<Integer>> listAll=new ArrayList<>();
    /**
     * 递归方法，运行时间24ms，占用内存9692k
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if(root==null) return listAll;
        list.add(root.val);
        target-=root.val;
        if(target==0 && root.left==null&&root.right==null)
            listAll.add(new ArrayList<>(list));
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);//这个是用来删除当前结点，无论成不成，成了，本来就已经保存在listAll里面了，不成就更要删除了
        return listAll;
    }
}
