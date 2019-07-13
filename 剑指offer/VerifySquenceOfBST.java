package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/3 22:13
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 算法思路：
 * 后序遍历为左右根，二叉搜索树满足左子树所有结点值均小于根节点的值，右子树的值大于根节点的值。
 * 逻辑是这样的，序列最后一个结点必然是根节点，那么根结点前面的比它值大的就是右子树，再前面只有都比根节点小才是左子树，
 * 再分别判断左右子树，使用递归的方法。
 * 参考链接：https://blog.csdn.net/as1072966956/article/details/83040550
 */
public class VerifySquenceOfBST {
    /**
     * 递归方法：运行时间17ms，占用内存：9308k
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence){
        if(sequence.length==0) return false;
        if (sequence.length==1) return true;
        return isPos(sequence,0,sequence.length-1);
    }

    private static boolean isPos(int[] sequence,int start,int end){
        if(start>=end) return true;
        int i=end;
        for(;i>=start;i--){
            if(sequence[end]>sequence[i]) break;
        }
        for(int j=0;j<=i-1;j++){
            if (sequence[j]>sequence[end]) return false;
        }
        return isPos(sequence,start,i) &&isPos(sequence,i+1,end-1);
    }
}
