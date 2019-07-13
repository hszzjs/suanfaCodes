package com.company.offer;


import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2018/12/26 14:45
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：对称的二叉树
 */
public class isSymmetrical {
    /**
     * 运行时间：17ms，占用内存：9300k
     * 参考链接：https://blog.csdn.net/JingLisen/article/details/82078332
     * @param pRoot
     * @return
     */
    public boolean isSymmetrical(TreeNode pRoot){
        if(pRoot==null) return true;
        return isSymmetrical(pRoot.left,pRoot.right);
    }
    public boolean isSymmetrical(TreeNode p1,TreeNode p2){
        if (p1==null && p2==null) return true;
        if(p1==null || p2==null) return false;
        if (p1.val!=p2.val) return false;
        return isSymmetrical(p1.left,p2.right) && isSymmetrical(p1.right,p2.left);
    }
}
