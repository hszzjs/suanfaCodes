package com.company.nowLeetCode.String;

/**
 * Author:   hszzjs
 * Date:     2019/2/24 12:44
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_intToRoman {
    /**
     * 七个罗马数字：I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）
     * 直接使用递归的方法，将结果拼在一起，效率较低。
     * @param num
     * @return
     */
    public String intToRoman(int num){
        if (num>=1000) return "M"+intToRoman(num-1000);
        if (num>=900) return "CM"+intToRoman(num-900);
        if (num>=500) return "D"+intToRoman(num-500);
        if (num>=400) return "CD"+intToRoman(num-400);
        if (num>=100) return "C"+intToRoman(num-100);
        if (num>=90) return "XC"+intToRoman(num-90);
        if (num>=50) return "L"+intToRoman(num-50);
        if (num>=40) return "XL"+intToRoman(num-40);
        if (num>=10) return "X"+intToRoman(num-10);
        if (num>=9) return "IX"+intToRoman(num-9);
        if (num>=5) return "V"+intToRoman(num-5);
        if (num>=4) return "IV"+intToRoman(num-4);
        if (num>=1) return "I"+intToRoman(num-1);
        return "";
    }

    /**
     * 这个就是将递归的做法转换成非递归的，事实上重点就是罗马数字与数字的对应关系。
     * @param num
     * @return
     */
    public String intToRoman1(int num){
        String res="";
        String[] symbol={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] val={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for (int i=0;num!=0;i++){
            if (num>=val[i]){
                res+=symbol[i];
                num-=val[i];
            }
        }
        return res;
    }
}
