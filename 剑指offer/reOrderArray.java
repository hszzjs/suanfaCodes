package com.company.offer;

/**
 * Author:   hszzjs
 * Date:     2018/11/29 22:23
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 算法思路：
 * 从头到尾扫描这个数组，一旦碰到偶数，就将该数后面的所有数全部向前挪一位，这样数组末尾就会空出一个位置，
 * 然后将该偶数插入末尾。这样就可以保证偶数的相对位置不会发生任何变化。为了避免一直在当前位置搞鬼，
 * 最后使用一个计数器证明已经搞定所有数目。
 */
public class reOrderArray {
    /**
     * 这个方法输出打乱了偶数的相对顺序
     * @param array
     */
    /**
    public void reOrderArray(int[] array){
        if (array==null && array.length==0){
            return;
        }
        for(int i=0,j=0;i<array.length;++i){
            if((array[i]&0x1)!=0){
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                ++j;
            }
        }
    }
     */

    /**
     * 运行时间：15ms，占用内存：9332k
     * @param array
     */
    public void reOrderArray(int[] array){
        if(array==null && array.length==0) return;
        int len=array.length;
        int cnt=0;
        for(int i=0;i<len&&cnt<len;++i){
            ++cnt;
            int temp=array[i];
            if((temp&0x1)==0){
                for (int j=i;j<len-1;++j){
                    array[j]=array[j+1];
                }
                array[len-1]=temp;
                --i;
            }
        }
    }
    /**
     * 自己做的额更好理解点
     */
    public void reOrderArray1(int[] array){
        if(array==null || array.length<2) return;
        int i=0,cnt=0;//两个指针，i指向偶数的第一个数，cnt指向需要判断奇偶的数，所以如果cnt指向偶数直接后移，如果指向奇数，就将偶数集体后移插入
        for(;i<array.length && cnt<array.length;i++){
            if(array[cnt]%2!=0){
                int tmp=array[cnt];
                for(int j=cnt;j>i;j--){
                    array[j]=array[j-1];
                }
                array[i]=tmp;
            }else i--;
            cnt++;
        }
    }
}
