package com.company.nowLeetCode.Stack;

import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2019/2/18 10:22
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Stack_largestRectangleArea {
    /**
     * 这个方法就是暴力搜索了，遍历每一个值，从该值开始向前向后分别遍历直到遇到比它小的值，然后更新最大面积值.
     * 时间复杂度：O(n^2)，空间复杂度O(1)
     * @param height
     * @return
     */
    public static int largestRectangleArea(int[] height){
        if (height==null || height.length==0) return 0;
        if (height.length==1) return height[0];
        int max=Integer.MIN_VALUE;
        for (int i=0;i<height.length;i++){
            int index=1;
            for (int j=i+1;j<height.length;j++){
                if (height[j]<height[i]) break;
                else index++;
            }
            for (int j=i-1;j>=0;j--){
                if (height[j]<height[i]) break;
                else index++;
            }
            max=Math.max(max,height[i]*index);
        }
        return max;
    }

    /**
     * 用栈的这个思路剑指太过于巧妙，就是按照递增序列加入栈，一旦遇到不是递增，那就弹出栈顶元素，然后它在栈中的下一个元素
     * 就是比栈顶小的元素索引值，要知道最开始弹出的栈顶元素就是局部峰值，所以向前没有比它大的，向后有比它小的，所以就是局部最大值*它的长度，
     * 而且栈中不为空，就是栈中总比i对应值大，那么就是一直弹出可以得到它的局部最大值。必须要靠画面感。
     * 时间复杂度O(n)
     * 参考链接：http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
     * @param height
     * @return
     */
    public int largestRectangleArea1(int[] height){
        Stack<Integer> stack=new Stack<>();
        int max=0;
        for (int i=0;i<=height.length;i++){
            if (stack.isEmpty() || height[stack.peek()]<=height[i]){
                stack.push(i);
            }else {
                int top=stack.pop();
                max=Math.max(max,height[top]*(stack.isEmpty()?i:i-1-stack.peek()));
                i--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height=new int[]{2,1,2};
        System.out.println(largestRectangleArea(height));
    }
}
