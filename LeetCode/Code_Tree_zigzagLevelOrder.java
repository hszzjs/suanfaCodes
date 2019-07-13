package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

import java.util.*;

/**
 * Author:   hszzjs
 * Date:     2019/2/15 11:21
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_zigzagLevelOrder {
    /**
     * 这个体无论借助什么结构都是无济于事。必须进行翻转。
     * 反正我是试过只使用栈、或者结合栈以及队列进行输出，均有异常。
     * 所以咯，就是对于偶数行进行标志，然后去借用Collections里面的翻转函数
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        int count=0;//这里用来记录其二叉树的层数
        TreeNode lastNode=root;     //下一个结点
        TreeNode LevalLastNode=root;//层结束的那个点
        ArrayList<Integer> tmp=new ArrayList<>();
        queue.add(root);
        while(queue.size()!=0){
            TreeNode node = queue.poll();
            tmp.add(node.val);//将这一层的放入tmp
            if(node.left!=null){
                queue.add(node.left);
                lastNode = node.left;
            }
            if(node.right!=null){
                queue.add(node.right);
                lastNode = node.right;
            }
            if(node==LevalLastNode){
                LevalLastNode=lastNode;
                if(count%2!=0){
                    Collections.reverse(tmp);
                }
                res.add(new ArrayList<>(tmp));
                tmp.clear();
                count++;
            }
        }
        return res;
    }
}
