package org.ljnpng.algorithm.linkednode.twopoint;

import org.ljnpng.algorithm.domain.ListNode;

/**
 * 876. 链表的中间结点
 */
public class N0876MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p1 != null && p1.next != null) {
            p2 = p2.next;
            p1 = p1.next.next;
        }
        return p2;
    }

}
