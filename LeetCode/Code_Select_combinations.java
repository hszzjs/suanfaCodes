package com.company.nowLeetCode.Select;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2019/2/20 16:35
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_combinations {
    /**
     * 自己写的，也就是递归，但是不能之前就有了，还要有序
     * @param n
     * @param k
     * @return
     */
    public static ArrayList<ArrayList<Integer>> combine(int n,int k){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (k>n) return res;
        ArrayList<Integer> list=new ArrayList<>();
        getCombinations(n,k,1,res,list);
        return res;
    }

    public static void getCombinations(int n,int k,int nIndex,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list){
        if (k==0) res.add(new ArrayList<>(list));
        for (int i=nIndex;i<=n;i++){
            if (!list.contains(i)){
                list.add(i);
                getCombinations(n,k-1,i+1,res,list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res=combine(4,1);
        for (ArrayList<Integer> list:res){
            for (int k:list){
                System.out.print(k+"==");
            }
            System.out.println();
        }
    }
}
