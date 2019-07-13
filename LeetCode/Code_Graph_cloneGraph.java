package com.company.nowLeetCode.Few;

import com.company.basicStructrue.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Author:   hszzjs
 * Date:     2019/2/26 18:19
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_Graph_cloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if (node==null) return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> hashMap=new HashMap<>();
        LinkedList<UndirectedGraphNode> queue=new LinkedList<>();
        UndirectedGraphNode head=new UndirectedGraphNode(node.label);
        hashMap.put(node,head);
        queue.add(node);
        while (!queue.isEmpty()){
            UndirectedGraphNode cur=queue.poll();
            for (UndirectedGraphNode nei:cur.neighbors){
                if (!hashMap.containsKey(nei)){
                    queue.add(nei);
                    UndirectedGraphNode newnei=new UndirectedGraphNode(nei.label);
                    hashMap.put(nei,newnei);
                }
                hashMap.get(cur).neighbors.add(hashMap.get(nei));
            }
        }
        return head;
    }
}
