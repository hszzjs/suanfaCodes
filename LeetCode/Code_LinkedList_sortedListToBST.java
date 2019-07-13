package com.company.nowLeetCode.LinkedList;

import com.company.basicStructrue.ListNode;
import com.company.basicStructrue.TreeNode;

/**
 * Author:   hszzjs
 * Date:     2019/2/16 20:08
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class Code_LinkedList_sortedListToBST {
    /**
     * 将有序序列转换为二叉树，那就是相当于中序遍历转换。需要找到中点作为root，然后前半部分后半部分，所以需要mid的前一个结点用于截断链表。
     * 然后就是偶数个的时候使用后半点作为中点，所以需要注意取中点的循环截止条件。
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode s = head, q = head, premid = null;
        while (q != null && q.next != null) {
            premid = s;
            s = s.next;
            q = q.next.next;
        }
        ListNode r = s.next;
        premid.next = null;
        TreeNode root = new TreeNode(s.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(r);
        return root;
    }
}
