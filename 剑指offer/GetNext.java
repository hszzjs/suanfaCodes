package com.company.offer;


import com.company.basicStructrue.TreeLinkNode;

/**
 * Author:   hszzjs
 * Date:     2018/12/26 13:43
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：二叉树的下一个结点
 */
public class GetNext {
    /**
     * 运行时间：26ms，占用内存：9640k
     * 参考链接：https://blog.csdn.net/weixin_41835916/article/details/80831349
     * 算法思路：如果该结点有右子树，那么下一个结点就是右子树最左边的点；
     * 如果没有右子树，那么就要看该结点是父节点的左孩子还是右孩子，右孩子，那么下一个结点就是父节点的父节点的父节点...直到
     * 该父节点是其父节点的左孩子，如果没有就是尾结点；左孩子，那么下一个结点就是其父节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode==null) return null;
        if(pNode.right!=null){
            pNode=pNode.right;
            while (pNode.left!=null) pNode=pNode.left;
            return pNode;
        }
        while (pNode.next!=null){
            if (pNode.next.left==pNode) return pNode.next;
            pNode=pNode.next;
        }
        return null;
    }
}
