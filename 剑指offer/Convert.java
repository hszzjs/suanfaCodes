package com.company.offer;


import com.company.basicStructrue.TreeNode;

import java.util.LinkedList;

/**
 * Author:   hszzjs
 * Date:     2018/12/9 16:13
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 算法思路：
 * 就是使用一个栈，先将左结点放入栈，然后开始取出左结点，然后根，然后右结点。
 * 注意：
 * 二叉搜索树：左《根《右，这里指的是所有结点
 * 链表就是有pre以及next，因为这里最后要返回TreeNode所以这里的left就是pre，right就是next。
 */
public class Convert {
    /**
     * 非递归方法，运行时间18ms，运行内存9688k
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree==null) return null;
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode current=pRootOfTree;
        TreeNode preNode=null;
        boolean isFirst=true;
        while (current!=null||!stack.isEmpty()){
            while (current!=null){
                stack.push(current);
                current=current.left;
            }
            if(!stack.isEmpty()){
                current=stack.pop();
                if(isFirst){
                    pRootOfTree=current;
                    preNode=pRootOfTree;
                    isFirst=false;
                }else {
                    preNode.right=current;
                    current.left=preNode;
                    preNode=current;
                }
                current=current.right;
            }
        }
        return pRootOfTree;
    }
}
