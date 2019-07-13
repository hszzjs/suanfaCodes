package com.company.nowLeetCode.Select;

import java.util.*;

/**
 * Author:   hszzjs
 * Date:     2019/2/20 6:46
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Select_findLadders {
    /**
     * 就是佛了，一直无法通过，但是这个就必然是正确的，否则怎么可能直接复制已经通过的代码，都没有通过
     * 果然牛客网上这个倒通过率低是有原因的
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict){
        dict.add(start);
        dict.add(end);
        HashMap<String,ArrayList<String>> nexts=getnexts(dict);
        HashMap<String,Integer> distances=distancesfromstart(start,nexts);
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        ArrayList<String> list=new ArrayList<>();
        if (!distances.containsKey(end)) return res;
        getDistanceList(start,end,nexts,distances,res,list);
        return res;
    }

    public static HashMap<String,ArrayList<String>> getnexts(HashSet<String> dict){
        HashMap<String,ArrayList<String>> res=new HashMap<>();
        for (String word:dict){
            char[] wordChar=word.toCharArray();
            ArrayList<String> list=new ArrayList<>();
            for (int i=0;i<wordChar.length;i++){
                char tmp=wordChar[i];
                for (char c='a';c<='z';c++){
                    if (c==tmp) {
                        continue;
                    }
                    else {
                        wordChar[i]=c;//换了以后，之后要记得到换回来
                        if (dict.contains(String.valueOf(wordChar)))
                        {
                            list.add(String.valueOf(wordChar));
                        }
                        wordChar[i]=tmp;
                    }
                }
            }
            res.put(word,list);
        }
        return res;
    }

    public static HashMap<String,Integer> distancesfromstart(String start,HashMap<String,ArrayList<String>> nexts){
        HashMap<String,Integer> res=new HashMap<>();
        Queue<String> queue=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();
        res.put(start,1);
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()){
            String word=queue.poll();
            ArrayList<String> list=nexts.get(word);
            for (String next:list){
                if (!visited.contains(next)){
                    res.put(next,res.get(word)+1);
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return res;
    }

    public static void getDistanceList(String cur,String end,HashMap<String,ArrayList<String>> nexts,
                                                    HashMap<String,Integer> distances,ArrayList<ArrayList<String>> res,
                                                    ArrayList<String> list){//递归寻找
        list.add(cur);
        if (cur.equals(end)){
            res.add(new ArrayList<>(list));
        }else {
            for (String word:nexts.get(cur)){
                if (distances.get(word)==distances.get(cur)+1)//因为是最近距离，所以需要每次都是按照+1前进
                    getDistanceList(word,end,nexts,distances,res,list);
            }
        }
        list.remove(cur);//一旦执行那个完毕，就需要清空之前放进去的东西
    }

    public static void main(String[] args) {
        HashSet<String> dict=new HashSet<>();
        String start="hit";
        String end="cog";
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        HashMap<String,ArrayList<String>> nexts=getnexts(dict);
        for (String word:dict){
            ArrayList<String> list=nexts.get(word);
            for (String next:list){
                System.out.println(word+"====="+next);
            }
        }
        ArrayList<ArrayList<String>> res=findLadders(start,end,dict);
        for (ArrayList<String> arr:res){
            for (String word:arr){
                System.out.print(word+"--");
            }
            System.out.println("");
        }
        System.out.println(findLadders(start,end,dict));
    }
}
