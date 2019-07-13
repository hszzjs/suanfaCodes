package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

import java.util.ArrayList;

public class Code_Tree_sumNumbers {
    /**
     * 这个题其实并不难，重点就是扣边界，卡了我真的是佛了，注意什么时候达到向ArrayList里面放的条件
     * 会不会出现重复放的情况
     * @param root
     * @return
     */
    public static int sumNumbers(TreeNode root){
        if (root==null) return 0;
        ArrayList<Integer> arr=new ArrayList<>();
        getSum(arr,root,root.val);
        int res=0;
        for (int i:arr){
            res+=i;
        }
        return res;
    }

    public static void getSum(ArrayList<Integer> arr, TreeNode root, int pathSum){
        if (root.left==null && root.right==null) arr.add(pathSum);
        else {
            if (root.left!=null) {
                getSum(arr,root.left,pathSum*10+root.left.val);
            }
            if (root.right!=null){
                getSum(arr,root.right,pathSum*10+root.right.val);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(0);
//        node.left=new TreeNode(1);
        node.right=new TreeNode(3);
        System.out.println(sumNumbers(node));
    }
}
