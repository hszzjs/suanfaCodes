package com.company.nowLeetCode.Array;

import com.company.basicStructrue.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Author:   hszzjs
 * Date:     2019/2/22 13:54
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Array_MergeIntervals {
    /**
     * 由于给出的Interval并不是按照顺序，所以需要排序，排序使用自己设计的比较器
     * 然后按照顺序连接即可
     * @param intervals
     * @return
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals){
        ArrayList<Interval> res=new ArrayList<>();
        if (intervals==null || intervals.size()==0) return res;
        if (intervals.size()==1) return intervals;
        Collections.sort(intervals,new IntervalComparator());
        Interval pre=intervals.get(0);
        for (Interval interval:intervals){
            if (pre.end>=interval.start){
                pre.end=Math.max(pre.end,interval.end);
            }else {
                res.add(pre);
                pre=interval;
            }
        }
        res.add(pre);
        return res;
    }

    class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval i1,Interval i2){
            return i1.start-i2.start;
        }
    }
}
