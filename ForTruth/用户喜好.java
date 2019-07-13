package com.company.ForTruth.zijietiaodong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/4/11 10:17
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class 用户喜好 {
    /**
     * Approach:HashMap+BinarySearch
     * 根据题目的数据量，可以推测出该题的时间复杂度在O(nlogn)级别
     * 所以就想到了二分查找
     * 首先利用HashMap记录每个喜好程度下的人员编号
     * 因为按照编号大小输入，所以map下的每个list里面的编号就是有序的了（从小到大）
     * 然后根据left和right在对应的list中进行查询人数区间
     * 就是借助了HashMap的数据结构，然后需要找到（查找问题，根据时间复杂度，就使用二分法）
     */

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();//用户个数
            Map<Integer,ArrayList<Integer>> map=new HashMap<>();
            for(int i=0;i<n;i++){
                map.computeIfAbsent(sc.nextInt(),x->new ArrayList<>()).add(i);
            }
            int q=sc.nextInt();//查询组数
            for(int i=0;i<q;i++){
                int left=sc.nextInt()-1,right=sc.nextInt()-1,k=sc.nextInt();
                if(!map.containsKey(k)){
                    System.out.println(0);
                }else {
                    ArrayList<Integer> list=map.get(k);
                    int leftRst=lowerRound(list,left);
                    int rightRst=upperRound(list,right);
                    // list 中不存在对应的范围（查询范围越界）
                    // left > list中的最大值 || right < list中的最小值
                    if(leftRst==list.size()||right==-1){
                        System.out.println(0);
                        continue;
                    }
                    System.out.println(rightRst-leftRst+1);
                }
            }
        }
        sc.close();
    }

    private static int lowerRound(ArrayList<Integer> list,int target){
        int left=0,right=list.size();
        while (left<right){
            int mid=(left+right)/2;
            if(target<=list.get(mid)){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }

    private static int upperRound(ArrayList<Integer> list,int target){
        int left=-1,right=list.size()-1;
        while (left<right){
            int mid=(left+right)/2;
            if(target>=list.get(mid)){
                left=mid;
            }else {
                right=mid-1;
            }
        }
        return right;
    }
}
