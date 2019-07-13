package com.company.nowLeetCode.Select;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author:   hszzjs
 * Date:     2019/2/20 21:51
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_combinationSum2 {
    /**
     * 这个就是添加一个数组，就是说明当前元素是否使用过
     * @param num
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num,int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null||num.length==0)
            return res;
        ArrayList<Integer> item  = new ArrayList<Integer>();
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        helper(num,target,0,item,res,visited);
        return res;
    }
    private void helper(int[] num,int target,int start,ArrayList<Integer> item,ArrayList<ArrayList<Integer>> res,boolean[] visited){
        if(target<0)
            return;
        if(target==0){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=start;i<num.length;i++){
            if(!visited[i]){
                if(i>0&&num[i]==num[i-1]&&visited[i-1]==false)
                    continue;
                item.add(num[i]);
                visited[i]=true;
                int newtarget = target-num[i];
                helper(num,newtarget,i+1,item,res,visited);
                visited[i]=false;
                item.remove(item.size()-1);
            }
        }
    }
}
