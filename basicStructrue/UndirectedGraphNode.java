package com.company.basicStructrue;

import java.util.ArrayList;

/**
 * Author:   hszzjs
 * Date:     2019/2/26 18:19
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x){
        label=x;
        neighbors=new ArrayList<>();
    }
}
