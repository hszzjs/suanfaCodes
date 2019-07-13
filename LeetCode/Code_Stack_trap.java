package com.company.nowLeetCode.Stack;

import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2019/2/18 12:43
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Stack_trap {
    /**
     * 借用了上一道题的使用栈，但是这个是递减块，然后就是边界问题需要细抠。因为这个是求和，然后计算的是每次能放多少。
     * 首先对于两边这种，不是闭合递减状态，就需要判断下是否栈是否为空，为空就是0了，不做操作，非空的话才会计算。
     * 然后是盛水，所以需要考虑到两边的较小值
     * @param A
     * @return
     */
    public static int trap(int[] A){
        Stack<Integer> stack=new Stack<>();
        int sum=0;
        for (int i=0;i<A.length;i++){
            if (stack.isEmpty() || A[i]<=A[stack.peek()]){
                stack.push(i);
            }else {
                int top=stack.pop();
                if(stack.isEmpty()) {
                    i--;
                    continue;
                }
                int temp=Math.min(A[stack.peek()],A[i])-A[top];
                sum+=temp*(i-1-stack.peek());
                i--;
            }
        }
        return sum;
    }

    /**
     * 这个是使用两个指针分别从两边向内前进，只要两个指针lr没有相遇，那就从较小指针向前走毕竟要兜住，如果较小指针是l也就是左侧，
     * 先l前进，毕竟当前值是min了，就判断lr相遇没有，而且是否是递减，如果没相遇且递减，那就l所在的那一柱可以盛水min-A[l]的水，
     * l再前进，直到是l走到比min还要大的值，就需要重新判断左右值，毕竟那个时候不一定右边可以兜住，右边同理。
     * @param A
     * @return
     */
    public int trap1(int[] A) {
        if(A==null || A.length ==0)
            return 0;
        int l = 0;
        int r = A.length-1;
        int res = 0;
        while(l<r)
        {
            int min = Math.min(A[l],A[r]);
            if(A[l] == min)
            {
                l++;
                while(l<r && A[l]<min)//希望是没有越界，然后是递减序列，如果是递增那就不操作
                {
                    res += min-A[l];
                    l++;
                }
            }
            else
            {
                r--;
                while(l<r && A[r]<min)
                {
                    res += min-A[r];
                    r--;
                }
            }
        }
        return res;
    }

}
