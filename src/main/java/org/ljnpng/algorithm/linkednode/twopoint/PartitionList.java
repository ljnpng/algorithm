package org.ljnpng.algorithm.linkednode.twopoint;

import org.ljnpng.algorithm.domain.ListNode;
//[1,4,3,2,5,2]
//3
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(-1);
        ListNode list2 = new ListNode(-1);
        ListNode p = head, p1 = list1, p2 = list2;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }
        //当前节点复用的是原链表的节点，而其 next 指针可能指向一个小于 x 的节点
        p2.next = null;

        // 链接两个链表
        p1.next = list2.next;
        return list1.next;
    }
}
