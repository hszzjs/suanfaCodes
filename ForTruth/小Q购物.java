package com.company.ForTruth.Tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:   hszzjs
 * Date:     2019/5/21 15:00
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目描述：
 * 小Q去商场购物，经常会遇到找零的问题。小Q现在手上有n种不同面值的硬币，每种面值的硬币都有无限多个。
 为了方便购物，小Q希望带尽量少的硬币，并且要能组合出1到m之间（包含1和m）的所有面值。
 输入格式
 第一行包含两个整数m和n。接下来n行，每行一个整数，第 i+1 行的整数表示第 i 种硬币的面值。
 输出格式
 输出一个整数，表示最少需要携带的硬币数量。如果无解，则输出-1。
 数据范围
 1≤n≤100,1≤m≤10^9，1≤硬币面值≤10^9
 输入样例：
 20 4
 1
 2
 5
 10
 输出样例：
 5
 */
public class 小Q购物 {
    /**
     * 这个题目首先说明就是可以凑出所有面值指的就是当前随意一个值都可以凑出来，但是一旦某个硬币被用了，凑不出来也可以。
     * 所以我们可以这样想：首先将所有面值排序，那么大于m的硬币必然是用不上了，那么就是从剩下的硬币凑，要凑出1~m，那么就是
     * 以上面为示例，从现有的硬币面额出发，使用1面额，必然凑出到1就可以凑出[1,2)，然后接着使用2就可以凑出[2,5)，毕竟如果有5，
     * 直接使用硬币5就可以，然后使用5基于前面的数目凑出[5,10)，然后就是使用10基于前面的额凑出[10,20)，此时就有一个bug就是
     * 最终凑出的最大面额是m，所以选择在初始的硬币面额数组末尾放一个m+1也就是21，那么就是使用10凑出[10,20]，那么就可以了。
     * 整个过程提炼下：
     * 面额数组arr,就是(arr[i+1]-1-cur+arr[i]-1)/arr[i]为每次新加的硬币数，cur为当前能凑出的最大值了，然后是要向上取整的所以+arr[i]-1
     * 就每次使用arr[i]来凑必然是不能超过arr[i+1]，超过了就可以直接使用arr[i+1]。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(),n=sc.nextInt();
        int[] arr=new int[n+1];
        for (int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        Arrays.sort(arr,0,n);
        if (arr[0]!=1) System.out.println(-1);
        else {
            //去除价值比m大的硬币
            while (n>0 && arr[n-1]>m) n--;
            arr[n]=m+1;//避免越界，最后设置一个m+1
            int res=0;
            for (int i=0,s=0;i<n;i++){
                int k=(arr[i+1]-1-s+arr[i]-1)/arr[i];
                res+=k;
                s+=arr[i]*k;
            }
            System.out.println(res);
        }
    }
}
