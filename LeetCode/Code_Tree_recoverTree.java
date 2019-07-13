package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/15 14:51
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_recoverTree {
    TreeNode first,second;
    TreeNode pre;

    /**
     * 这个是采用递归进行处理，我一直纠结的点在于如何在树中交换呢。果然就是直接取出来两个树节点交换就可以。
     * 递归方法最终是为了得到两个应该交换的树结点。
     * 记住，树里面所有说的都是指针。所以这里应用指针有，存被交换的两个指针，然后为了与父节点比较，需要一个指针指向父节点。
     * @param root
     */
    public void recoverTree(TreeNode root){
        process(root);
        if (first!=null && second!=null){
            int tmp=first.val;
            first.val=second.val;
            second.val=tmp;
        }
    }
    public void process(TreeNode root){
        if (root==null) return;
        if (root.left!=null) process(root.left);
        if (pre!=null&&root.val<pre.val){
            if (first==null){
                first=pre;
                second=root;//万一只有两个结点就是错的
            }else {
                second=root;
            }
        }
        pre=root;
        if (root.right!=null){
            process(root.right);
        }
    }
}
