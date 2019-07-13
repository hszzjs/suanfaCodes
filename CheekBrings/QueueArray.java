package com.company.CheekBrings;

/**
 * Author:   hszzjs
 * Date:     2019/6/12 16:01
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class QueueArray {
    Object[] a;//对象数组，队列最多存储a.length-1个对象
    int front;//队首下标
    int rear;//队尾下标
    public QueueArray(){
        this(10);//调用其他构造方法
    }
    public QueueArray(int size){
        a=new Object[size];
        front=0;
        rear=0;
    }

    /**
     * 将对象放入队列
     * @param obj
     * @return 队列满时返回false，否则返回true
     */
    public boolean enqueue(Object obj){
        if ((rear+1)%a.length==front) return false;
        a[rear]=obj;
        rear=(rear+1)%a.length;
        return true;
    }

    /**
     * 对列头部的第一个对象出队
     * @return 出队的对象，队列空时返回null
     */
    public Object dequeue(){
        if (rear==front) return null;
        Object obj=a[front];
        front=(front+1)%a.length;
        return obj;
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(4);
        System.out.println(q.enqueue("张三"));
        System.out.println(q.enqueue("李斯"));
        System.out.println(q.enqueue("赵五"));
        System.out.println(q.enqueue("王一"));//无法入队列，队列满
        for(int i=0;i<4;i++){
            System.out.println(q.dequeue());
        }
    }
}
