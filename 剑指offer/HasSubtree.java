package com.company.offer;


import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2018/12/3 8:38
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 算法思路：
 * 两种方法不相上下，所以主要看第一种，得到两个树的后序遍历（左右根），使用ArrayList来存放，
 * 然后判断两个ArrayList之间是否有包含关系，有，就是子树
 * 算法链接：https://blog.csdn.net/wushuomin/article/details/79943737
 */
public class HasSubtree {
    /**
     *递归方法，运行时间20ms，占用内存：9228k
     * @param root1
     * @param root2
     * @return
     */
    /**
    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        if(root1==null || root2==null) return false;
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        getPostOrder(root1,list1);
        getPostOrder(root2,list2);
        if(list1.containsAll(list2)) return true;
        return false;
    }

    private void getPostOrder(TreeNode root,ArrayList<Integer> list){
        if(root==null) return;//终止结点
        getPostOrder(root.left,list);//左
        getPostOrder(root.right,list);//右
        list.add(root.val);//根
    }
     */
    /**
     * 另一种递归方法，运行时间19ms，占用内存：9548k
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2){
        if(root1==null || root2==null) return false;
        boolean result=false;
        if(root1.val==root2.val) result=check(root1,root2);
        if(!result) result=HasSubtree(root1.right,root2);
        if(!result) result=HasSubtree(root1.left,root2);
        return result;
    }

    private boolean check(TreeNode node1,TreeNode node2){
        if(node2==null) return true;
        if(node1==null) return false;
        if (node1.val!=node2.val) return false;
        return check(node1.left,node2.left) && check(node1.right,node2.right);
    }
}
