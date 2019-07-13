package com.company.CheekBrings;

import java.util.HashMap;

/**
 * Author:   hszzjs
 * Date:     2019/5/15 21:24
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 设计LFU（least frequently used）即最近不经常使用算法，结构，实现如下结构：
 * ① void set(int key，int value):加入或修改key对应的value；
 * ② int get(int key)：查询key对应的value值
 */
public class LFU缓存结构 {
    /**
     * 算法核心：记录每一个元素的访问频率，当容器满了，每次移除频率较小的元素，如果两个元素的频率相同，就先移除添加容器较早的元素。
     * 算法思路：
     * 依旧是使用双端链表以及hashmap的结构进行算法设计，这里说明需要建立的结点Node是包含key、value、使用次数times，必然还有上一个结点up、
     * 下一个结点down。然后就是存储结构使用的是桶，每个桶是一个双端链表，表示的是使用次数相同的结点，新的结点时放在头部，然后桶与桶之间
     * 也是通过链表的形式连接，所以创建桶结构NodeList需要包含head、tail、前一个桶last、后一个桶next。
     * 接下来就是基于桶结构实现LFU缓存了，需要实现方法：
     * 需要设置key与node的关系表records，node与桶NodeList的关系map，整个结构最左边的桶，然后最大容量，当前size
     * ① set：那就是看当前key是否可以在records里面找到对应的结点，可以找到，那就是需要结点更新，然后在对应的桶里面将其删掉，然后结点
     * 需要放在次数更新后的桶，此时可能没有对应的桶，可能有。如果没有对应的结点，那就创建新的结点，然后放入次数为1的桶的头部；
     * ② get：get以后次数也是要更新加1的，然后动作重复
     */
    public class Node{
        public Integer key;
        public Integer value;
        public Integer times;//这个节点发生get或者set的次数总和
        public Node up;//节点之间是双向链表，所以有上一个结点
        public Node down;//这就是下一个结点
        public Node(int key,int value,int times){
            this.key=key;
            this.value=value;
            this.times=times;
        }
    }
    //桶结构
    public class NodeList{
        public Node head;//桶结构的头结点
        public Node tail;
        public NodeList last;//桶之间是双向链表，所以有前一个桶
        public NodeList next;//后一个桶
        public NodeList(Node node){
            this.head=node;
            this.tail=node;
        }
        //将新节点放入桶，新的结点放在头部
        public void addNodeFromHead(Node newHead){
            newHead.down=this.head;
            this.head.up=newHead;
            this.head=newHead;
        }
        //判断桶是否为空
        public boolean isEmpty(){
            return head==null;
        }
        //删除node结点并保证node的上下文环境重新连接
        public void deleteNode(Node node){
            if(head==tail){
                head=null;
                tail=null;
            }else {
                if(node==head){
                    head=node.down;
                    head.up=null;
                }else if (node==tail){
                    tail=node.up;
                    tail.down=null;
                }else {
                    node.up.down=node.down;
                    node.down.up=node.up;
                }
            }
            node.up=null;
            node.down=null;
        }
    }
    public class LFUCache{
        private int capacity;//缓存的大小限制
        private int size;//缓存目前有多少结点
        private HashMap<Integer,Node> records;//表示key由哪个结点代表
        private HashMap<Node,NodeList> heads;//表示结点在那个桶里面
        private NodeList headList;//整个结构中位于最左的桶；
        public LFUCache(int k){
            this.capacity=k;
            this.size=0;
            this.records=new HashMap<>();
            this.headList=null;
            this.heads=new HashMap<>();
        }
        private boolean modifyHeadList(NodeList removeNodeList){
            if(removeNodeList.isEmpty()){
                if(headList==removeNodeList){
                    headList=removeNodeList.next;
                    if (headList!=null) headList.last=null;
                }else {
                    removeNodeList.last.next=removeNodeList.next;
                    if (removeNodeList.next!=null)
                        removeNodeList.next.last=removeNodeList.last;
                }
                return true;
            }
            return false;
        }
        private void move(Node node,NodeList oldNodeList){
            oldNodeList.deleteNode(node);
            NodeList preList=modifyHeadList(oldNodeList)?oldNodeList.last:oldNodeList;
            NodeList nextList=oldNodeList.next;
            if (nextList==null){
                NodeList newList=new NodeList(node);
                if (preList!=null)
                    preList.next=nextList;
                newList.last=preList;
                if (headList==null)
                    headList=newList;
                heads.put(node,newList);
            }else {
                if (nextList.head.times.equals(node.times)){
                    nextList.addNodeFromHead(node);
                    heads.put(node,nextList);
                }else {
                    NodeList newList=new NodeList(node);
                    if (preList!=null)
                        preList.next=newList;
                    newList.last=preList;
                    newList.next=nextList;
                    nextList.last=newList;
                    if(headList==nextList)
                        headList=newList;
                    heads.put(node,newList);
                }
            }
        }
        public void set(int key,int value){
            if(records.containsKey(key)){
                Node node=records.get(key);
                node.value=value;
                node.times++;
                NodeList curNodeList=heads.get(node);
                move(node,curNodeList);
            }else {
                if (size==capacity){
                    Node node=headList.tail;
                    headList.deleteNode(node);
                    modifyHeadList(headList);
                    records.remove(node.key);
                    heads.remove(node);
                    size--;
                }
                Node node=new Node(key,value,1);
                if (headList==null)
                    headList=new NodeList(node);
                else {
                    if (headList.head.times.equals(node.times))
                        headList.addNodeFromHead(node);
                    else {
                        NodeList newList=new NodeList(node);
                        newList.next=headList;
                        headList.last=newList;
                        headList=newList;
                    }
                }
                records.put(key,node);
                heads.put(node,headList);
                size++;
            }
        }
        public Integer get(int key){
            if(!records.containsKey(key)) return null;
            Node node=records.get(key);
            node.times++;
            NodeList curNodeList=heads.get(node);
            move(node,curNodeList);
            return node.value;
        }
    }
}
