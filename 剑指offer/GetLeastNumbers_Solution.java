package com.company.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author:   hszzjs
 * Date:     2018/12/16 9:48
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 算法思路：这道题事实上就是在考排序，所以在除了使用Arrays里面的排序，可以自己去实现排序算法来搞
 */
public class GetLeastNumbers_Solution {
    /**
     * 运行时间24ms，占用内存9520k
     * 算法思路：使用Arrays里面的排序，就是从小到大排序的所以直接取前4个就可以，这里利用原有的java包
     * @param input
     * @param k
     * @return
     */
    /**
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input,int k){
        ArrayList<Integer> res=new ArrayList<>();
        if(k>input.length) return res;
        Arrays.sort(input);
        for(int i=0;i<k;i++) res.add(input[i]);
        return res;
    }
     */
    /**
     * 运行时间31ms，占用内存9664k
     * 算法思路：利用了堆排序，就是建立一个只有k个元素的最大堆，后面的元素进来时先与堆顶元素进行比较，如果比堆顶元素大，则放不进去，
     * 如果比堆顶元素小，就删除堆顶元素，放入堆以及重新排序（放进去就自动重新排序了），一直到结束即可。
     * 这里的堆的建立是使用了优先队列，然后需要定义优先队列的比较方法。
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input,int k){
        ArrayList<Integer> res= new ArrayList<>();
        int n=input.length;
        if(k>n||k==0) return res;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<n;i++){
            if(maxHeap.size()!=k) maxHeap.offer(input[i]);
            else if (maxHeap.peek()>input[i]){
                Integer tmp=maxHeap.poll();
                tmp=null;
                maxHeap.offer(input[i]);
            }
        }
        for(Integer integer:maxHeap){
            res.add(integer);
        }
        return res;
    }
}
