package com.company.CheekBrings;

import java.util.HashMap;

/**
 * Author:   hszzjs
 * Date:     2019/5/15 19:49
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 1. 设计LRU（last recently used）缓存结构，要求在构造是确定大小K，并且有如下两个功能：
 * ① set(key,value):将记录(key,value)插入该结构
 * ② get(key)：返回key对应的值
 */
public class LRU缓存结构 {
    /**
     * LRU的设计原则：如果一个数据在最近一段时间没有被访问到，那么在将来被访问到的可能就很小
     * 这个的设计思想：
     * 使用两个HashMap以及双端队列结合的方式实现，首先说明队列头部永远是写的是旧值，而更新后就放在队列的末尾。
     * 而明显java自带的双端队列是不满足这些操作的，所以需要自己实现双端队列，但是双端队列实现的是基于什么数据结构呢？明显就是Node，
     * 所以首先创建类Node<V>，其中包括指针last，next以及值value。而双端队列必然是包括队列的首尾head以及tail，需要实现的操作就是：
     * ① 构造函数，首尾设置为空；② 添加结点，就是如果队列是空的，甚至于添加必然就是在队列尾添加；③ 其中某个结点被使用了，
     * 就需要将其挪到队列尾部，但是可能这个结点本身就在队列尾，可能是head，可能只是普通结点；④ 一旦缓存结构超容了，就会需要从头部删除
     * 结点，可能head本身就是null，可能只有一个结点。
     * 然后两个HashMap是为了建立key与node的关系，一个是key为键，一个是node为键，缓存结构初始化的时候一定要设置capacity
     */
    public class Node<V>{
        public V value;
        public Node<V> last;
        public Node<V> next;
        public Node(V value){
            this.value=value;
        }
    }
    public class NodeDoubleLinkedList<V>{
        private Node<V> head;
        private Node<V> tail;
        public NodeDoubleLinkedList(){
            this.head=null;
            this.tail=null;
        }
        public void addNode(Node<V> newNode){
            if(newNode==null) return;
            if(this.head==null){
                this.head=newNode;
                this.tail=newNode;
            }else {
                this.tail.next=newNode;
                newNode.last=this.tail;
                this.tail=newNode;
            }
        }
        public void moveNodeTail(Node<V> node){
            if(this.tail==node) return;
            if(this.head==node){
                this.head=node.next;
                this.head.last=null;
            }else {
                node.last.next=node.next;
                node.next.last=node.last;
            }
            node.last=this.tail;
            node.next=null;
            this.tail.next=node;
            this.tail=node;
        }
        public Node<V> removeHead(){
            if(this.head==null) return null;
            Node<V> res=this.head;
            if(this.head==this.tail){
                this.head=null;
                this.tail=null;
            }else {
                this.head=res.next;
                res.next=null;
                this.head.last=null;
            }
            return res;
        }
    }
    public class LRUcache<K,V>{
        private HashMap<K,Node<V>> keyNodeMap;
        private HashMap<Node<V>,K> nodeKeyMap;
        private NodeDoubleLinkedList<V> nodeList;
        private int capacity;
        public LRUcache(int capacity){
            if(capacity<1) throw new RuntimeException("should be more than 0.");
            this.keyNodeMap=new HashMap<>();
            this.nodeKeyMap=new HashMap<>();
            this.nodeList=new NodeDoubleLinkedList<>();
            this.capacity=capacity;
        }
        public V get(K key){
            if(this.keyNodeMap.containsKey(key)){
                Node<V> res=this.keyNodeMap.get(key);
                this.nodeList.moveNodeTail(res);
                return res.value;
            }
            return null;
        }
        public void set(K key,V value){
            if(this.keyNodeMap.containsKey(key)){
                Node<V> node=this.keyNodeMap.get(key);
                node.value=value;
                this.nodeList.moveNodeTail(node);
            }else {
                Node<V> newNode=new Node<>(value);
                this.keyNodeMap.put(key,newNode);
                this.nodeKeyMap.put(newNode,key);
                this.nodeList.addNode(newNode);
                if (this.keyNodeMap.size()==this.capacity+1){
                    this.removeMostUnusedCache();
                }
            }
        }
        private void removeMostUnusedCache(){
            Node<V> removeNode=this.nodeList.removeHead();
            K removeKey=this.nodeKeyMap.get(removeNode);
            this.nodeKeyMap.remove(removeNode);
            this.keyNodeMap.remove(removeKey);
        }
    }
}
