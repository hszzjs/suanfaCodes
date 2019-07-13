package com.company.offer;


import com.company.basicStructrue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:   hszzjs
 * Date:     2018/12/26 15:46
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 题目：序列化以及反序列化二叉树
 */
public class Serialize {
    //序列化使用的是前序遍历，只不过null的地方要加#
    String Serialize(TreeNode root) {
        if (root==null) return "#,";
        StringBuilder res=new StringBuilder(root.val+",");
        res.append(Serialize(root.left));
        res.append(Serialize(root.right));
        return res.toString();
    }
    TreeNode Deserialize(String str) {
        String[] res=str.split(",");
        Queue<String> queue=new LinkedList<>();
        for (int i=0;i<res.length;i++){
            queue.offer(res[i]);
        }
        return pre(queue);
    }
    TreeNode pre(Queue<String> queue){
        String val=queue.poll();
        if (val.equals("#")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(val));
        node.left=pre(queue);
        node.right=pre(queue);
        return node;
    }
}
