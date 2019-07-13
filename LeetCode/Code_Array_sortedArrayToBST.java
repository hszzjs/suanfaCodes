package com.company.nowLeetCode.Array;

import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 19:48
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num){
        if (num==null || num.length==0) return null;
        if (num.length==1) return new TreeNode(num[0]);
        TreeNode root=process(num,0,num.length-1);
        return root;
    }

    public TreeNode process(int[] num,int left,int right){
        if (left>right) return null;
        int mid=(left+right)/2+(left+right)%2;//这个很挫的一点是，一般情况下中点是相加除2，但是这个题抽风就是使用下一个，所以还要加上取余的
        TreeNode root=new TreeNode(num[mid]);
        root.left=process(num,left,mid-1);
        root.right=process(num,mid+1,right);
        return root;
    }
}
