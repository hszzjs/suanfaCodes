package com.company.offer;

import java.util.HashMap;

/**
 * Author:   hszzjs
 * Date:     2018/12/18 16:11
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    /**
     * 运行时间23ms，占用内存9568k
     * 自己想的，就是使用了HashMap
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array,int num1[],int num2[]){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])) map.put(array[i],1);
            else{
                map.replace(array[i],map.get(array[i])+1);
            }
        }
        boolean t=true;
        for(Integer in:map.keySet()){
            if (map.get(in)==1){
                if(t) {
                    num1[0]=in;
                    t=false;}
                else{
                    num2[0]=in;
                    break;
                }
            }
        }
    }
}
