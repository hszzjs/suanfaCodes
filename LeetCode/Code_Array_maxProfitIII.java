package com.company.nowLeetCode.Array;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 16:15
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_maxProfitIII {
    /**
     * 这个属于超神做法，并看不明白，放弃
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2;
    }

    /**
     * 这个就是普通做法，最多只能完成两笔交易，而且交易键没有重叠，那么就是分区找最大
     * 就从i~n-1，针对每一个i，看prices的子序列，[0,..,i][i,...,n-1]上分别获取的最大利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int len = prices.length;
        int maxProfit = 0;
        int min = prices[0];
        int arrayA[] = new int[len];

        for(int i=1;i<prices.length;i++){//这个获取最小价格，然后第i个的最大利润，是和之前比较的也就是[0,..,i]
            min=Math.min(min,prices[i]);
            arrayA[i]=Math.max(arrayA[i-1],prices[i]-min);
        }

        int max = prices[len-1];
        int arrayB[] = new int[len];
        for(int i = len-2; i >= 0; i--){//这个是[i,...,len-1]
            max = Math.max(prices[i],max);
            arrayB[i] = Math.max(max-prices[i],arrayB[i+1]);
        }

        for(int i = 0; i < len; i++){
            maxProfit = Math.max(maxProfit,arrayA[i] + arrayB[i]);
        }

        return maxProfit;
    }
}
