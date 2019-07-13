package com.company.nowLeetCode.String;

/**
 * Author:   hszzjs
 * Date:     2019/2/24 14:40
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_convert {
    /**
     * 这道题主要还是总结规律，根据写出来的Z形可以看到每行都是一列一列，除了第一行以及最后一行，其他行都会每两个元素都会插入一个元素，
     * 可以看到每列之间相邻元素索引相差2*Rows-2个，然后就是中间插的那个元素与它同行的前一个元素相差j+(2*Rows-2)-2*i个索引。
     * 这样就可以了
     * @param s
     * @param nRows
     * @return
     */
    public String convert(String s,int nRows){
        if (s==null || s.length()==0 || nRows<=0) return "";
        if (nRows==1) return s;
        StringBuilder sb=new StringBuilder();
        int size=nRows*2-2;
        for (int i=0;i<nRows;i++){
            for (int j=i;j<s.length();j+=size){
                sb.append(s.charAt(j));
                if (i!=0 && i!=nRows-1){
                    int tmp=j+size-2*i;
                    if (tmp<s.length()) sb.append(s.charAt(tmp));
                }
            }
        }
        return sb.toString();
    }
}
