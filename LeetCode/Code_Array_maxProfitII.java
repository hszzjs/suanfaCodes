package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 16:15
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_maxProfitII {
    /**
     * 随着日子的前进，在递减的最小点，买入，在递增区域的最大点卖出，这个注意边界条件，必须在最后一天前卖出。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int len=prices.length;
        if (len<=1) return 0;
        int i=0;
        int sum=0;
        while (i<len-1){//这个包含买入的时间所以边界条件是i<len-1，为卖出留有时间
            int buy,sell;
            while (i+1<len && prices[i+1]<prices[i]) i++;//买入，边界条件相同
            buy=i;
            i++;
            while (i<len && prices[i]>=prices[i-1]) i++;//卖出，就可以是在最后一天卖出，要包含最后一天的价格所以使用i-1进行比较
            sell=i-1;
            sum+=prices[sell]-prices[buy];
        }
        return sum;
    }
}
