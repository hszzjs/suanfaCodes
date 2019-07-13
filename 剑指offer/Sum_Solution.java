package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/20 16:25
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum_Solution {
    /**
     * 运行时间：14ms，占用内存：9168k
     * 算法思路：由于不能使用一系列，所以这里就使用递归的方法，但是又如何来判断递归的终止条件，于是就使用短路与。
     * 短路与这里的原理就是使用两个&&就会使得n<0的时候不执行后面的代码了，刚好可以作为终止条件
     * @param n
     * @return
     */
    public int Sum_Solution(int n){
        int sum=n;
        //短路与，当n小于0的时候，就不执行后面的代码了
        boolean ans=(n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
