package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/16 20:59
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution {
    /**
     * 运行时间15ms，占用内存9336k
     * 参考链接：https://blog.csdn.net/u013309870/article/details/67012369
     * 算法思路：
     * 使用一个数组将已经求出来的丑数存起来，然后依次用2,3,5乘上数组中已经求出来的丑数，选出其中最小的一个保存在数组中。
     * 按照这样的思路去循环，存够数。
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index){
        if(index==0) return 0;
        int ugly[]=new int[index];
        ugly[0]=1;
        int uglyindex=1,min;
        int nextIndex2=0,nextIndex3=0,nextIndex5=0;//起始时都是从第一个也就是0的那一项开始计算
        while (uglyindex<index){
            min=ugly[nextIndex2]*2<ugly[nextIndex3]*3?ugly[nextIndex2]*2:ugly[nextIndex3]*3;//min用于保存新产生的大于当前数组的最大值的最小丑数
            min=min<ugly[nextIndex5]*5?min:ugly[nextIndex5]*5;
            ugly[uglyindex]=min;
            while (ugly[nextIndex2]*2<=min) nextIndex2++;//更新乘的参数，这样就可以减少计算量
            while (ugly[nextIndex3]*3<=min) nextIndex3++;
            while (ugly[nextIndex5]*5<=min) nextIndex5++;
            uglyindex++;
        }
        return ugly[index-1];
    }
}
