package com.company.ForTruth.拼夕夕;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;

/**
 * Author:   hszzjs
 * Date:     2019/5/14 20:54
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 小镇沿街分布（可以理解为都在数轴上），有n家银行（位置以数轴的坐标表示，金额表示可以被抢走的金额）。两个绑匪试图分别抢劫一个银行，
 * 为了让警方多奔波他们商定选择的两个银行距离不小于d。请问，符合约定的情况下他们能抢到的总金额最大是多少。
 输入格式
 输入包含 n+1 行。第一行包含两个整数 n 和 d，分别表示银行的数量和约定的距离。
 接下来 n 行，每行包含两个整数 a 和 b ，分别表示坐标和金额。
 输出格式
 输出一个数字表示可以获得的最大金额。
 数据范围
 1≤n≤2∗105,
 1≤d,a,b≤108
 注意：数据中保证至少存在两个银行之间的距离不小于 d。
 输入样例：
 6 3
 1 1
 3 5
 4 8
 6 4
 10 3
 11 2
 输出样例：
 11
 */
public class 避嫌抢劫 {
    static class bank{
        int location,money;
        public bank(int a,int b){
            this.location=a;
            this.money=b;
        }
    }

    /**
     * 暴力必然超时
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),d=sc.nextInt();
        bank[] banks=new bank[n];
        for (int i=0;i<n;i++){
            banks[i]=new bank(sc.nextInt(),sc.nextInt());
        }
        int res=0;
        for(int i=0;i<banks.length;i++){
            for(int j=i+1;j<banks.length;j++){
                if(Math.abs(banks[i].location-banks[j].location)>=d)
                    res=Math.max(res,banks[i].money+banks[j].money);
            }
        }
        System.out.println(res);
    }

    /**
     * 这个是对于双指针做法的普遍优化，这里有一个遍历条件就是距离要大于等于d，所以将位置按照升序排序，
     * 就是只要遍历i以及i前面的银行，找到最大钱就可以。这个就是双指针做法优化的模板。
     * 这里说一下，这个代码AC不AC全凭运气，有时候超时有时候就AC了，最后检查出来原因在于对于输入数据的读取
     * @param args
     */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        bank[] banks = new bank[n];
        for (int i = 0; i < n; i++) {
            banks[i] = new bank(sc.nextInt(), sc.nextInt());
        }
        int res=0,curMax = 0, j = -1;
        // 按位置升序排序
        Arrays.sort(banks, Comparator.comparing(bank -> bank.location));
        for(int i=0;i<banks.length;++i){
            while (j+1<i && Math.abs(banks[i].location-banks[j+1].location)>=d){
                ++j;
                curMax = Math.max(curMax, banks[j].money);
            }
            res = Math.max(res, curMax + banks[i].money);
        }
        System.out.println(res);
    }

    /**
     * 换了输入数据的读取就完全A，百度了下看到是Scanner的平均耗时是BufferedReader的10倍左右
     * @param input
     * @return
     */
    private static int[] stringToint(String input) {
        String[] parts = input.trim().split(" ");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = stringToint(br.readLine().trim());
        int n = firstLine[0], d = firstLine[1];
        bank[] banks = new bank[n];

        for (int i = 0; i < n; ++i) {
            String line = br.readLine();
            if (line == null || line.length() == 0)
                break;
            int[] num = stringToint(line);
            banks[i] = new bank(num[0], num[1]);
        }

        int res=0,curMax = 0, j = -1;
        // 按位置升序排序
        Arrays.sort(banks, Comparator.comparing(bank -> bank.location));
        for(int i=0;i<banks.length;++i){
            while (j+1<i && Math.abs(banks[i].location-banks[j+1].location)>=d){
                ++j;
                curMax = Math.max(curMax, banks[j].money);
            }
            res = Math.max(res, curMax + banks[i].money);
        }
        System.out.println(res);
    }
}
