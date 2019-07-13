package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Code_Tree_postorderTraversal {
    /**
     * 这里使用了递归的方法，接下来就是尝试非递归的方法
     * @param root
     * @return
     */
    public ArrayList<Integer> postorderTraversal1(TreeNode root){
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        getPostOrder(res,root);
        return res;
    }

    public void getPostOrder(ArrayList<Integer> res,TreeNode root){
        if (root==null) return;
        getPostOrder(res,root.left);
        getPostOrder(res,root.right);
        res.add(root.val);
    }

    /**
     * 这里使用了非递归的方法，借用了栈，因为是后序遍历比较麻烦，注意放入栈节点的顺序。
     * 还有一点就是对于何时弹出栈并放入ArrayList中？树的末尾比较好设置，左右子树为空放入ArrayList中，但是如果是中间的节点呢？
     * 这里就需要设置一个pre的指针，指向之前放入ArrayList的节点，只要pre指向的节点是当前节点的左子树或者右子树，就证明这个节点的
     * 子树已经检验过了，该结点是目前子树的根节点
     * @param root
     * @return
     */
    public ArrayList<Integer> postorderTraversal2(TreeNode root){
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre=null;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur=stack.peek();
            if ((cur.left==null && cur.right==null)|| (pre!=null && (pre==cur.right || pre==cur.left))) {
                res.add(cur.val);
                stack.pop();
                pre=cur;
            }else {
                if (cur.right!=null) {
                    stack.push(cur.right);
                }
                if (cur.left!=null){
                    stack.push(cur.left);
                }
            }
        }
        return res;
    }
}
