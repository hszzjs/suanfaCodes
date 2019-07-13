package com.company.offer;


import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2018/12/26 16:26
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：二叉搜索树的第k个结点
 * 算法思路：它或者是一棵空树，或者是具有下列性质的二叉树：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
 * 即二叉搜索树不空时：左子树 < 根结点 < 右子树
 * 中序遍历二叉搜索树即可得到一个有序序列
 */
public class KthNode {
    int index=0;
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot!=null&&k>=0){
            //先在左子树进行遍历
            TreeNode node=KthNode(pRoot.left,k);
            if(node!=null) return node;
            if (++index==k) return pRoot;
            //如果左子树没有，那就右子树遍历
            node=KthNode(pRoot.right,k);
            if(node!=null) return node;
        }
        return null;
    }
}
