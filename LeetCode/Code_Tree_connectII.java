package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

public class Code_Tree_connectII {
    /**
     * 非完美二叉树依旧完美解决，主要就是依靠了之前的按层写树。但是问题在于是否可以使用递归的方法呢？试试。
     * 不能应用递归，因为就不是完美二叉树。
     * 但是可以使用三指针法，以及层次递进法。
     * 此题的宗旨就是无论是结点的左右子树的next，必然是与结点以及结点的next相关的。
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
            if (curSize==0){
                cur.next=null;
                curSize=nextSize;
                nextSize=0;
            }else {
                cur.next=queue.peek();
            }
        }
    }

    /**
     * 使用了三个指针，就是父节点指针father，用于在它的右子树结点的next连接，就是father.next的子树。
     * 关键就是first指针用于记录每层开始的地方，使得father可以完美的切换到下一层，
     * 至于last就是一直在动，用于连接next
     * @param root
     */
    public void connectThreePointers(TreeLinkNode root){
        if (root==null) return;
        TreeLinkNode father=root;
        TreeLinkNode first=null;
        TreeLinkNode last=null;
        while (father!=null){
            if (first==null){
                if (father.left!=null) first=father.left;
                else if (father.right!=null) first=father.right;
            }
            if (father.left!=null){
                if (last!=null){
                    last.next=father.left;
                }
                last=father.left;
            }
            if (father.right!=null){
                if (last!=null) last.next=father.right;
                last=father.right;
            }
            if (father.next!=null){
                father=father.next;
            }else {
                father=first;
                first=null;
                last=null;
            }
        }
    }
}
