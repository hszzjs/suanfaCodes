package com.company.nowLeetCode.String;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Author:   hszzjs
 * Date:     2019/2/23 12:41
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_String_simplifyPath {
    /**
     * 这个路径是由规则的，根据规则：
     * 当遇到“/../"则需要返回上级目录，需检查上级目录是否为空。
     * 当遇到"/./"则表示是本级目录，无需做任何特殊操作。
     * 当遇到"//"则表示是本级目录，无需做任何操作。
     * 当遇到其他字符则表示是文件夹名，无需简化。
     * 当字符串是空或者遇到”/../”，则需要返回一个"/"。
     * 当遇见"/a//b"，则需要简化为"/a/b"。
     * 这里就必然是先根据“/”将字符串分为子字符串，主要原因是由返回上一个文件夹，所以这里就使用栈来进行操作。
     * 遇到.或者空不操作，遇到文件名进入栈，遇到..就弹出栈。但是这样是无法直接进行拼接的所以使用另外一个栈，后进先出，
     * 排成正确顺序，使用StringBuilder。
     * @param path
     * @return
     */
    public String simplifyPath(String path){
        if (path==null || path.length()==0) return path;
        Stack<String> stack=new Stack<>();
        String[] list=path.split("/");
        for (String s:list){
            if (s.equals(".") || s.equals("")) continue;
            else if (!s.equals("..")) stack.push(s);
            else if (!stack.isEmpty()) stack.pop();
        }
        Stack<String> stack1=new Stack<>();
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            stack1.push(stack.pop());
        }
        while (!stack1.isEmpty()){
            sb.append("/"+stack1.pop());
        }
        if (sb.length()!=0) return sb.toString();
        else return "/";
    }

    /**
     * 这个就很优秀，对于很多部分就已经进行了优化，然后使用LinkedList替换了两个栈，毕竟是双端队列
     * @param path
     * @return
     */
    public String simplifyPath1(String path){
        if (path==null || path.length()==0) return path;
        String[] list=path.split("/");
        LinkedList<String> linkedList=new LinkedList<>();
        for (String s:list){
            if (s.equals(".") || s.equals("")) continue;
            else if (!s.equals("..")) linkedList.push(s);
            else if (!linkedList.isEmpty()) linkedList.pop();
        }
        if (linkedList.isEmpty()) linkedList.push("");
        String res="";
        while (!linkedList.isEmpty()){
            res+="/"+linkedList.removeLast();
        }
        return res;
    }
}
