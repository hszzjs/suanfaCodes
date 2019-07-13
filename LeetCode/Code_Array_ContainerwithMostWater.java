package com.company.nowLeetCode.Array;


/**
 * Author:   hszzjs
 * Date:     2019/2/22 8:33
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_ContainerwithMostWater {
    /**
     * 这道题与使用栈那个题不一样高的是，那个是bar也就是自己就可以作为容器，而这里是直线，所以使用双指针更合适
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        if (height==null || height.length<2) return 0;
        int max=0,left=0,right=height.length-1;
        while (left<right){
            max=Math.max(max,(right-left)*Math.min(height[left],height[right]));
            if (height[left]<height[right]) left++;
            else right--;
        }
        return max;
    }
}
