package com.company.nowLeetCode.Tree;

/**
 * Author:   hszzjs
 * Date:     2019/2/15 16:39
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Tree_numTrees {
    /**
     * 这个体事实上就是用的动态规划解的。想了下这样去理解，有n个结点的二叉搜索树的种类数，根节点为1,2，...，n的二叉搜索树的种数之和。
     * 而当根节点为1时，剩下的所有结点是作为1的右子树，这是可以看到这恰好是有n-1个结点的二叉搜索树的种类数，当根节点为2时，左子树只有一个结点1，
     * 右子树有n-2个结点（连续的数），那么他的种类数就由左子树的种类数*右子树的种类数，依次类推得到所有种类数。
     * 这里可以看到，当计算n的时候，必须知道总节点数为0，...，n-1的所有结点数目对应的种类数。
     * 再一想到当初说的动态规划就是建表，所以这里就建立的一维的数组进行存取。
     * 仔细想有点类似于中序遍历。
     * @param n
     * @return
     */
    public int numTrees(int n){
        if (n<3) return n;
        int[] arr=new int[n+1];
        arr[0]=1;
        arr[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                arr[i]+=arr[j-1]*arr[i-j];
            }
        }
        return arr[n];
    }
}
