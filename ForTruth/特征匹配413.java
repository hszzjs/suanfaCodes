package com.company.ForTruth.zijietiaodong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/9 10:27
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 小明是一名算法工程师,同时也是一名铲屎言。某天,他突发奇想,想从猫咪的视频里挖掘一些猫咪的运动信息。为了提取运动信息,
 * 他需要从视频的每一帧提取"猫咪特征".一个猫咪特征是一个两维的vector<x, y>.如果x_1=x_2 and y_1=y_2,那么这俩是同一个特征。
 * 因此,如果喵咪特征连续一致,可以认为喵咪在运动。也就是说,如果特征<a, b>在持续帧里出现,那么它将构成特征运动。
 * 比如,特征<a, b>在第2/3/4/7/8帧出现,那么该特征将形成两个特征运动2-3-4和7-8.现在,给定每一帧的特征,特征的数量可能不一样。
 * 小明期望能找到最长的特征运动。
 * 输入描述：
 * 第一行包含一个正整数N，代表测试用例的个数。
 * 每个测试用例的第一行包含一个正整数M， 代表视频的帧数。
 * 接下来的M行，每行代表一帧。其中，第一个数字是该帧的特征个数，
 * 接下来的数字是在特征的取值:比如样例输入第三行里，2代表该帧有两个猫咪特征，<1， 1>和<2, 2>
 * 所有用例的输入特征总数和<100000
 * N满足1<=N<=100000. M满足1<=M<=10000.一帧的特征个数满足S<=10000。特征取值均为非负整数。
 * 输出描述：对每一个测试用例，输出特征运动的长度作为一行
 * 示例：
 * 1
 * 8
 * 2 1 1 2 2
 * 2 1 1 1 4
 * 2 2 2 1 4
 * 0
 * 0
 * 1 1 1
 * 1 1 1
 * 1 1 1
 * 输出：3
 *
 * 思路：这个题就是较为简单，使用HashMap就可以，但是关键是数据量大的时候要快，所以这里在判断连续的时候
 * 创建了一个新的数据结构，就是它上一次出现的帧数，以及出现次数，所以每次判断出现过，通过所在帧可以判断是否连续。
 * 如果连续，就次数+1，否则就重置。
 * 然后就是HashMap的键问题，如果自己创建xy类，就会出现样例不等，所以使用字符串作为键最合适。
 */
public class 特征匹配413 {
    static class LC{
        int line,time;
        public LC(int line,int time){
            this.line=line;
            this.time=time;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        for(int i=0;i<N;i++){
            int n=sc.nextInt();
            int res=0;
            HashMap<String,LC> map=new HashMap<>();
            for(int t=0;t<n;t++){
                int size=sc.nextInt();
                for(int j=0;j<size;j++){
                    String xy=sc.nextInt()+"_"+sc.nextInt();
                    if(!map.containsKey(xy)) map.put(xy,new LC(t,1));
                    else{
                        if(map.get(xy).line+1!=t) map.put(xy,new LC(t,1));
                        else map.put(xy,new LC(t,map.get(xy).time+1));
                    }
                    res=Math.max(res,map.get(xy).time);
                }
            }
            System.out.println(res);
        }
    }
}
