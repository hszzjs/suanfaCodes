package com.company.nowLeetCode.Few;

import com.company.basicStructrue.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 11:27
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Sort_InsertInterval {
    /**
     * 前面已经做过使用比较器排序，这里说了是非重叠的，然后说是插入那就是相当于往里面加新的，再合并
     * 比较器之后，七点已经按照顺序，那就是比较前一个的end与后一个的start就可以判断是否重叠
     * @param intervals
     * @param newInterval
     * @return
     */
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals,Interval newInterval){
        ArrayList<Interval> res=new ArrayList<>();
        if (intervals ==null || intervals.size()==0) {
            res.add(newInterval);
            return res;
        }
        intervals.add(newInterval);
        Collections.sort(intervals,new comparator());
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

    public static class comparator implements Comparator<Interval>{
        public int compare(Interval i1,Interval i2){
            return i1.start-i2.start;
        }
    }

    public static void main(String[] args) {
        ArrayList<Interval> r=new ArrayList<>();
        r.add(new Interval(1,5));
        ArrayList<Interval> res=insert(r,new Interval(2,7));
        for (Interval interval:res){
            System.out.println(interval.start+"=="+interval.end);
        }
    }
}
