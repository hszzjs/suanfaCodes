package com.company.offer;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2018/12/18 16:31
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    /**
     * 运行时间37ms，占用内存9676k
     * 参考链接：https://blog.csdn.net/ouyangyanlan/article/details/72667622
     * 这里是使用了二元一次方程，(start+end)*(end-start+1)/2=sum;其中start为遍历值
     * @param sum
     * @return
     */
    /**
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(sum<3) return res;
        for(int i=1;i<=sum/2;i++){
            int value=1+4*i*i-4*i+8*sum;
            int valuesqrt=(int)Math.sqrt(value);
            if(value>=25&&valuesqrt*valuesqrt==value){
                ArrayList<Integer> path=new ArrayList<>();
                for(int j=i;j<=(valuesqrt-1)>>1;j++)
                    path.add(j);
                res.add(path);
            }
        }
        return res;
    }
     */
    /**
     * 运行时间27ms，占用内存9620k
     * @param sum
     * @return
     */
    /**
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if(sum<=1) return res;
        int small=1;
        int big=2;
        while (small!=(1+sum)/2){
            int curSum=(small+big)*(big-small+1)/2;
            if(curSum==sum){
                ArrayList<Integer> list=new ArrayList<>();
                for (int i=small;i<=big;i++){
                    list.add(i);
                }
                res.add(list);
                small++;big++;
            }else if(curSum<sum){
                big++;
            }else small++;
        }
        return res;
    }
     */
    /**
     * 运行时间25ms，占用内存9732k
     * 算法思路：暴力解法，双层循环遍历
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=1;i<(1+sum)/2;i++){
            int s=0;
            ArrayList<Integer> arr=new ArrayList<>();
            for(int j=i;j<sum;j++){
                if(s<sum){
                    s+=j;
                    arr.add(j);
                    if(s==sum){
                        res.add(arr);
                        break;
                    }
                }else break;
            }
        }
        return res;
    }
}
