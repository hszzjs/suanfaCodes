package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/15 14:45
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_isSameTree {
    /**
     * 就直接使用递归就可以了
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p,TreeNode q){
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;
        if (p.val!=q.val) return false;
        else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}
