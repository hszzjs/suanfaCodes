package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 16:15
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_maxProfit {
    /**
     * 这个的意思就是只能遍历一次，买在卖之前，买时最小，买时利益最高。那就按照要求来就可以
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        if (prices==null || prices.length==0) return 0;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for (int i=0;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }
}
