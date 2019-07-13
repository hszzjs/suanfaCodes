package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/15 20:42
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 * 链表的排序方法：快速排序、归并排序
 * 参考链接：https://www.cnblogs.com/morethink/p/8452914.html
 */
public class Code_LinkedList_sortList {

    public ListNode sortList(ListNode head){
        if (head==null || head.next==null) return head;
        quickSortLinkedList(head,null);
        return head;
    }

    /**
     * 单链表的快排，平均时间复杂度：O(nlogn)
     * 参考链接：
     * @param head
     * @return
     */
    public void quickSortLinkedList(ListNode head,ListNode end){
        if (head!=end){
            ListNode baseNode=patition(head,end);
            quickSortLinkedList(head,baseNode);
            quickSortLinkedList(baseNode.next,end);
        }
    }

    public ListNode patition(ListNode begin,ListNode end){
        ListNode p1=begin,p2=begin.next;
        while (p2!=end){//走到末尾才停
            if (p2.val<begin.val){//大于key值时，p1向前走一步，交换p1与p2的值
                p1=p1.next;
                int tmp=p2.val;
                p2.val=p1.val;
                p1.val=tmp;
            }
            p2=p2.next;
        }
        if (p1!=begin){//当有序时，不交换p1和key值
            int tmp=p1.val;
            p1.val=begin.val;
            begin.val=tmp;
        }
        return p1;
    }

    /**
     * 归并排序，重点是在于合并两个排好序的子链表。需要再三仔细理解
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode mid=getMid(head);
        ListNode  right=mid.next;
        mid.next=null;
        return mergeSortLinkedList(sortList2(head),sortList2(right));
    }

    public ListNode getMid(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode p1=head,p2=head;
        while (p2.next!=null && p2.next.next!=null) {//这里要注意的是要先检验快指针的next不为null，然后才有next.next不为null，否则会有异常
            p2=p2.next.next;
            p1=p1.next;
        }
        return p1;
    }

    public ListNode mergeSortLinkedList(ListNode head1,ListNode head2){
        ListNode p1=head1,p2=head2,head;
        if (head1.val<head2.val){
            head=head1;
            p1=p1.next;
        }else {
            head=head2;
            p2=p2.next;
        }
        ListNode p=head;
        while (p1!=null && p2!=null){
            if (p1.val<p2.val){
                p.next=p1;
                p1=p1.next;
            }else {
                p.next=p2;
                p2=p2.next;
            }
            p=p.next;
        }
        if (p1!=null){
            p.next=p1;
        }
        if (p2!=null){
            p.next=p2;
        }
        return head;
    }

    /**
     * 冒泡排序，从头至尾依次比较，将较大值放到最后，指针一个p放在head，一个tail放在最后也就是null，遍历直到p.next与tail相遇，
     * 所有结点遍历完毕，p指向链表中最大结点，tail指向p的结点，p又从头开始，然后继续遍历。
     * 时间复杂度分析，就是tail需要从尾到头遍历以便，tail每遍历一个结点，p都会从头到tail遍历一遍。所以时间复杂度是O(n^2)
     * @param head
     * @return
     */
    public ListNode bubbleSortLinkedList(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode p=head,tail=null;
        while (p.next!=tail){
            while (p.next!=tail){
                if (p.val>p.next.val){
                    int tmp=p.next.val;
                    p.next.val=p.val;
                    p.val=tmp;
                }
                p=p.next;
            }
            tail=p;
            p=head;
        }
        return head;
    }

    /**
     * 链表的插入排序就很直接了，遇到需要插入的结点，就先重链表中删除该结点，然后将该结点从最开始的结点依次进行比较，
     * 直到找到比它更大的结点，然后将该结点插入到这个结点前面。
     * @param head
     * @return
     */
    public ListNode InsertSortLinkedList(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode p=head.next,q=head;
        ListNode aux=new ListNode(Integer.MIN_VALUE);
        aux.next=head;
        while (p!=null){
            if (p.val<q.val){
                q.next=p.next;
                ListNode l1=aux,l2=aux.next;
                while (l2.val<p.val){
                    l1=l2;
                    l2=l2.next;
                }
                l1.next=p;
                p.next=l2;
                p=q.next;
            }else {
                q=p;
                p=p.next;
            }
        }
        return aux.next;
    }
}
