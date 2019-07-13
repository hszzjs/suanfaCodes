package com.company.nowLeetCode.Select;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2019/2/21 11:56
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_generateParenthesis {
    /**
     * 这道题依旧是使用递归进行深度优先搜索，递归的是，只要左右括号的个数都不为零，那就对应添加所有括号，
     * 然后有一个要求合法，就是剩下的左括号的个数不能多于右括号，否则就是）（。
     * @param n
     * @return
     */
    public ArrayList<String> generateParenthesis(int n){
        ArrayList<String> res=new ArrayList<>();
        if (n<=0) return res;
        String item=new String();
        process(res,item,n,n);
        return res;
    }

    public void process(ArrayList<String> res,String item,int left,int right){
        if (left>right) return;
        if (left==0 && right==0){
            res.add(new String(item));
            return;
        }
        if (left>0){
            process(res,item+'(',left-1,right);
        }
        if (right>0){
            process(res,item+')',left,right-1);
        }
    }
}
