package com.company.nowLeetCode.Tree;

import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/14 15:31
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_buildTreeByPreorderandInorder {
    /**
     * 妈的，道理一毛一样，但是为什么我的就是报错说出现边界问题。明天再上继续抠吧。真的是。
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (inorder == null || inorder.length == 0) {
            return null;
        }

        if (preorder.length != inorder.length) {
            return null;
        }
        TreeNode root=process(preorder,0,inorder,0,inorder.length-1);
        return root;
    }

    public static TreeNode process(int[] preorder,int preStart,int[] inorder,int inStart,int inEnd){
        TreeNode root=new TreeNode(preorder[preStart]);
        if(inEnd-inStart==0) return root;
        int inIndex=-1;
        for (int i=inStart;i<=inEnd;i++){
            if (inorder[i]==root.val) inIndex=i;
        }
        if (inIndex-1-inStart>=0) root.left=process(preorder,preStart+1,inorder,inStart,inIndex-1);
        if (inEnd-inIndex-1>=0) root.right=process(preorder,preStart-inStart+inIndex+1,inorder,inIndex+1,inEnd);
        //找到原因了，就是右子树的preStart的参数有问题。是要根据左子树的长度也就是（inIndex-1-inStart），还有一个根节点，
        // 从preStart开始，这么长就是右子树的根节点
        return root;
    }

    public static void main(String[] args) {
        int[] preorder=new int[]{1,2};
        int[] inorder=new int[]{2,1};
        System.out.println(buildTree(preorder,inorder).left.val);
    }
}
