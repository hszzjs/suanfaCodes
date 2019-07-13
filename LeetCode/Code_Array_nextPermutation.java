package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/22 14:32
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_nextPermutation {
    /**
     * 屎一样的题，首先解释题：
     * 生成下一个序列。对给定序列进行重排，生成一个字母顺序比它更大的下一个序列
     * 如果给定序列已经是按字母顺序排列最大的，就逆序排列。不使用额外空间，就是数字重新排。
     * 算法：
     * ① 从后向前遍历，找到第一个不满足降序的元素，若初始序列全是降序，就③
     * ② 将该元素同它后面的元素中比它大的第一个元素交换
     * ③ 将该元素后的所有元素逆序排列，称为最小排列。
     * @param num
     */
    public static void nextPermutation(int[] num){
        if (num==null || num.length<2) return;
        int i=num.length-2;
        for (;i>=0&&num[i]>=num[i+1];--i);//有等号就是说明，排除重复元素情况
        if(i>=0){
            int j=i+1;
            for (;j<num.length && num[j]>num[i];++j);
            swap(num,i,j-1);
        }
        int k=num.length-1;
        i++;
        for (;i<k;i++,k--)
            swap(num,i,k);//数组的反转就使用双指针，前后各一个，交换前进直至相遇

    }

    public static void swap(int[] num,int i,int j){
        int tmp=num[i];
        num[i]=num[j];
        num[j]=tmp;
    }

    public static void main(String[] args) {
        int[] n=new int[]{2,3,6,5,4,1};
        nextPermutation(n);
        for (int i:n){
            System.out.print(i);
        }
    }
}
