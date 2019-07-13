package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/12/18 15:11
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组为{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4
 */
public class GetNumberOfK {
    /**
     * 运行时间15ms，占用内存9324k
     * @param array
     * @param k
     * @return
     */
    /**
    public int GetNumberOfK(int[] array,int k){
        int num=0;
        if(array!=null && array.length>0){
            int firstKIndex=getFirstK(array,k,0,array.length-1);
            int lastKIndex=getLaskK(array,k,0,array.length-1);
            if(firstKIndex>-1&&lastKIndex>-1)
                num=lastKIndex-firstKIndex+1;
        }
        return num;
    }
    private int getFirstK(int[] array,int k,int start,int end){
        if(start>end) return -1;
        int middleIndex=(start+end)/2;
        int middleData=array[middleIndex];
        if(middleData==k){
            if(middleIndex>0&&array[middleIndex-1]!=k||middleIndex==0)
                return middleIndex;
            else end=middleIndex-1;
        }else if(middleData>k)
            end=middleIndex-1;
        else start=middleIndex+1;
        return getFirstK(array,k,start,end);
    }
    private int getLaskK(int[] array,int k,int start,int end){
        if(start>end) return -1;
        int middleIndex=(start+end)/2;
        int middleData=array[middleIndex];
        if(middleData==k){
            if(middleIndex<array.length-1&&array[middleIndex+1]!=k||
                    middleIndex==array.length-1)
                return middleIndex;
            else start=middleIndex+1;
        }else if(middleData<k) start=middleIndex+1;
        else end=middleIndex-1;
        return getLaskK(array,k,start,end);
    }
     */

    /**
     * 运行时间17ms，占用内存9240k、
     * 自己写的暴力法，所以时间上没有什么区别，那为什么要写那么长呢？
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array,int k){
        int cnt=0;
        for(int i=0;i<array.length;i++){
            if(cnt>0&&array[i]!=k ){
                break;
            }
            if(array[i]==k) cnt++;
        }
        return cnt;
    }
}
