package com.company.CheekBrings;

/**
 * Author:   hszzjs
 * Date:     2019/5/17 15:20
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 求m^k%p，时间复杂度O(logk)
 */
public class 快速幂算法模板 {
    public int qmi(int m, int k, int p){
        int res = 1, t = m;
        while(k > 0){
            if( (k&1) == 1){
                res = res * t % p;
            }
            t = t * t % p;
            k = k>>1;
        }
        return res;
    }
}
