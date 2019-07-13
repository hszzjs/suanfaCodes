package com.company.offer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author:   hszzjs
 * Date:     2018/12/21 21:46
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：数组中重复的数字
 * 说明：这里数组int[]duplication就是将找到的重复数字随便一个放到第一个位置就可以了。
 * 参考链接：https://www.cnblogs.com/hezhiyao/p/7670348.html
 */
public class duplicate {
    /**
     * 运行时间26ms，占用内存9600k
     * 算法思路：这里就是创建一个布尔数组k，因为长度n的数组里面的数字是在n~1范围内，所以就用k来表示里面的数字对应是否重复。
     * 所以开始的时候有了某个数，就将其设置为true，等到下一次发现这个位置是true，那就是重复的
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    /**
    public boolean duplicate(int numbers[],int length,int[] duplication){
        boolean[] k=new boolean[length];
        for(int i=0;i<k.length;i++){
            if(k[numbers[i]]==true){
                duplication[0]=numbers[i];
                return true;
            }
            k[numbers[i]]=true;
        }
        return false;
    }
     */
    /**
     * 运行时间：23ms，占用内存：9532k
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int[] duplication){
        boolean flag=false;
        if(numbers==null||length==0) return flag;
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        for(int num:numbers){
            if (map.containsKey(num)) map.put(num,map.get(num)+1);
            else map.put(num,1);
        }
        int val=-1;
        Set<Map.Entry<Integer,Integer>> set=map.entrySet();
        for(Map.Entry<Integer,Integer> es:set){
            int key=es.getKey();
            int value=es.getValue();
            if (value>=2){
                val=key;
                break;
            }
        }
        if(val!=-1){
            duplication[0]=val;
            flag=true;
        }
        return flag;
    }
}
