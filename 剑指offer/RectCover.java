package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/11/29 10:01
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 算法思路：没别的，就直接理解是斐波那契数列吧
 *            | 1, (n=1)
 *f(n) =     | 2, (n=2)
 *          | f(n-1)+f(n-2) ,(n>2,n为整数)
 */
public class RectCover {
    public int RectCover(int target){
        if(target<3) return target;
        int temp1=2;
        int temp2=1;
        int result=0;
        for(int i=3;i<=target;i++){
            result=temp1+temp2;
            temp2=temp1;
            temp1=result;
        }
        return result;
    }
}
