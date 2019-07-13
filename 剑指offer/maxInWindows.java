package com.company.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Author:   hszzjs
 * Date:     2018/12/26 20:15
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：滑动窗口的最大值
 */
public class maxInWindows {
    /**
     * 运行时间：18ms，占用内存9232k
     * 参考链接：https://www.cnblogs.com/rosending/p/5722541.html
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num,int size){
        ArrayList<Integer> res=new ArrayList<>();
        if (num==null || num.length<size||size==0) return res;
        Deque<Integer> deque=new ArrayDeque<>();
        for (int i=0;i<num.length;i++){
            if (!deque.isEmpty()&&(i-deque.peekFirst())==size) deque.pollFirst();//已经越界了，所以需要将第一个抛出
            while (!deque.isEmpty()&&num[i]>=num[deque.peekLast()]){//后面的值比队尾的还大
                deque.pollLast();
            }
            deque.offer(i);
            if (i>=(size-1)) res.add(num[deque.peekFirst()]);
        }
        return res;
    }
    /**
     * 使用了一个双端队列来保存来保存窗口中的数据的index，对这个队列的具体操作如下
     * 【虽然队列中保存的是index，但是为了方便描述，就直接描述为数据】：
     * 1. 在插入新数据的时候，如果队列为空就直接插入
     * 2. 如果队列不为空就判断新数据和队尾元素的大小，如果队尾元素小于新数据，那么我们可以确定，
     * 在包含队尾元素和新数据的窗口里面，一定是新数据最大，有了这个假设，我们就可以把队尾元素移除队列，
     * 然后重复这个比较，直到遇到一个比新数据大的数才停止出队列，然后再把新数据插入。
     *这个就保证了，在队首的数据一定是当前窗口中最大的，然后队首后面的是次大的数据，依次类推，我们
     */
}
