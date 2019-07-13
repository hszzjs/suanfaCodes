package com.company.nowLeetCode.Select;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author:   hszzjs
 * Date:     2019/2/20 21:30
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_combinationSum {
    /**
     * 就直接进行深度优先搜索使用递归，由于可以重复，所以每次的index是可以从i那里取
     * @param candidates
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,int target){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (candidates==null || candidates.length==0) return res;
        Arrays.sort(candidates);
        ArrayList<Integer> list=new ArrayList<>();
        process(candidates,res,0,target,list);
        return res;
    }
    public void process(int[] candidates, ArrayList<ArrayList<Integer>> res,int index,int target,ArrayList<Integer> list){
        if(target>0){
            for (int i=index;i<candidates.length;i++){
                if(target<candidates[i]) return;
                target-=candidates[i];
                if (target<0) return;
                list.add(candidates[i]);
                process(candidates,res,i,target,list);
                list.remove(list.size()-1);
                target+=candidates[i];
            }
        }if (target==0) {
            res.add(new ArrayList<>(list));
            return;
        }else return;
    }
}
