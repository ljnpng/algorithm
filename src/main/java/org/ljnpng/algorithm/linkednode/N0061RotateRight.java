package org.ljnpng.algorithm.linkednode;

import org.ljnpng.algorithm.domain.ListNode;

public class N0061RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int size = 0;
        ListNode p = head;
        while (p != null) {
            size++;
            p = p.next;
        }

        k = k % size;

        ListNode slow = head, fast = head;
        ListNode dummy = new ListNode(-1, head);
        dummy.next = head;

        while (k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
