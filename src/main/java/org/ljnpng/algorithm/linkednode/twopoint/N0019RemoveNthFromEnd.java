package org.ljnpng.algorithm.linkednode.twopoint;

import org.ljnpng.algorithm.domain.ListNode;

/**
 * 19.删除链表的倒数第 N 个结点
 */
public class N0019RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy, p2 = dummy;
        while (n > 0) {
            p1 = p1.next;
            n--;
        }

        while (p1.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        p2.next = p2.next.next;

        return dummy.next;
    }
}
