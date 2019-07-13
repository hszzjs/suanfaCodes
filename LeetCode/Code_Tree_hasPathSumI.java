package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/14 12:37
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_hasPathSumI {
    /**
     * 就是简答的进行递归，需要注意的就是能直接递归就直接递归，不要搞那麻烦的子函数
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum){
       if (root==null) return false;
       if (root.left==null && root.right==null) return root.val==sum;
       return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
