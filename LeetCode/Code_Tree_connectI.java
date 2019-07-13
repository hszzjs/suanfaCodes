package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:   hszzjs
 * Date:     2019/2/14 12:07
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 重要的事说八遍：参考链接简直太棒了
 * 参考链接：https://segmentfault.com/a/1190000003465911
 */
public class Code_Tree_connectI {
    /**
     * 这个题目是将完美二叉树进行转换，重点就是这里的完美二叉树，然后傻了吧，之前一直想转折点处队列里面加标志，但是忘了
     * 可以直接通过变量表示每层的结点数。对于队列的应用没有变化。
     * 时间复杂度O(N)，空间复杂度O(N)
     * 因为是完美二叉树，所以可以使用递归的方法进行处理，递归的时间、空间复杂度是相同的。
     * @param root
     */
    public void connect(TreeLinkNode root){
        if (root==null) return;
        Queue<TreeLinkNode> queue=new LinkedList<>();
        int curSize=1,nextSize=0;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeLinkNode cur=queue.poll();
            curSize--;
            if (cur.left!=null){
                queue.offer(cur.left);
                nextSize++;
            }
            if (cur.right!=null){
                queue.offer(cur.right);
                nextSize++;
            }
            if (curSize==0) {
                cur.next=null;
                curSize=nextSize;
                nextSize=0;
            }
            else cur.next=queue.peek();
        }
    }

    /**
     * 递归。左子树的next就是其父节点的右子树结点，而右子树的next就是父节点的next的左子树结点。
     * （搞明白o，递归情况下，默认上一轮是已经安排好的）
     * @param root
     */
    public void connect2(TreeLinkNode root){
        if (root==null) return;
        root.next=null;
        process(root);
    }

    private void process(TreeLinkNode root){
        if (root.left!=null) {
            root.left.next=root.right;
        }else return;
        if (root.right!=null) {
            root.right.next=root.next;
        }
        process(root.left);
        process(root.right);
    }
}
