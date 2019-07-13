package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2019/3/27 15:02
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class test {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) return false;
        if(root1.val!=root2.val){
            return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        }else{
            if(process(root1,root2)) return true;
            else{
                return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
            }
        }
    }

    private static boolean process(TreeNode root1,TreeNode root2){
        if(root2==null) return true;
        if(root1==null) return false;
        if(root1.val!=root2.val) return false;
        return process(root1.left,root2.left)&& process(root1.right,root2.right);
    }

    public static void main(String[] args) {
        Stack<Integer> s=new Stack<>();
        s.add(5);
        s.add(9);
        s.add(4);
        s.add(7);
        s.add(6);

        TreeNode root1=new TreeNode(8);
        TreeNode temp=new TreeNode(8);
        root1.right=temp;
        TreeNode temp1=new TreeNode(9);
        temp.right=temp1;
        TreeNode temp2=new TreeNode(2);
        temp1.right=temp2;
        TreeNode temp3=new TreeNode(5);
        temp2.right=temp3;

        TreeNode root2=new TreeNode(8);
        TreeNode temp4=new TreeNode(9);
        root2.right=temp4;
        TreeNode temp5=new TreeNode(3);
        temp4.left=temp5;
        TreeNode temp6=new TreeNode(2);
        temp5.right=temp6;

        System.out.println(HasSubtree(root1,root2));
    }
}
