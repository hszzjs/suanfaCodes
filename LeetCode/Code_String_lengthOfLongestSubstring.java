package com.company.nowLeetCode.String;

import java.util.HashSet;

/**
 * Author:   hszzjs
 * Date:     2019/2/24 15:34
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_lengthOfLongestSubstring {
    /**
     * 不重复，独一无二，就使用了hashSet，当然是从头到尾遍历找字串，每次遇到重复的，就从之前记录的起始位置找与它相同的元素，
     * 不是该元素，就从hashset中移除，直到找到，然后从重复的那个元素开始重新记录，遍历
     * 但是这个就是时间复杂度较高
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s){
        if (s==null ||s.length()==0) return 0;
        HashSet<Character> hashSet=new HashSet<>();
        int i=0,max=1;
        for (int j=0;j<s.length();j++){
            char c=s.charAt(j);
            if (!hashSet.contains(c)) {
                hashSet.add(c);
                max=Math.max(max,hashSet.size());
            }
            else {
                while (i<j){
                    if (s.charAt(i)==c){
                        i++;
                        break;
                    }
                    hashSet.remove(s.charAt(i));
                    i++;
                }
            }
        }
        return max;
    }

    /**
     * 这个事件复杂度降低了很多。。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s){
        if(s==null)
            return 0;
        boolean[] flag = new boolean[256];

        int result = 0;
        int start = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (flag[current]) {
                result = Math.max(result, i - start);
                // the loop update the new start point
                // and reset flag array
                // for example, abccab, when it comes to 2nd c,
                // it update start from 0 to 3, reset flag for a,b
                for (int k = start; k < i; k++) {
                    if (arr[k] == current) {
                        start = k + 1;
                        break;
                    }
                    flag[arr[k]] = false;
                }
            } else {
                flag[current] = true;
            }
        }

        result = Math.max(arr.length - start, result);

        return result;
    }
}
