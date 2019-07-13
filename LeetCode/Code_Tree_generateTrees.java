package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2019/2/15 19:11
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_generateTrees {
    /**
     * 这个题，我感觉我完全没有思路，佛了。等积累了一阵再说吧。
     *
     * @param n
     * @return
     */
    public ArrayList<TreeNode> generateTrees(int n){
        return createTree(1, n);
    }
    public ArrayList<TreeNode> createTree(int low, int high) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if(low > high) {
            result.add(null);
            return result;
        }
        for (int i = low; i <= high; i ++) {
            // 求根结点i的左右子树集合
            ArrayList<TreeNode> left = createTree(low, i - 1);
            ArrayList<TreeNode> right = createTree(i + 1, high);
            for (int j = 0; j < left.size(); j ++) {
                for (int k = 0; k < right.size(); k ++) {
                    // 将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与所有的左子树匹配
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = left.get(j);
                    newNode.right = right.get(k);
                    result.add(newNode);
                }
            }
        }
        return result;
    }
}
