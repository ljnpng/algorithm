package org.ljnpng.algorithm.sort;

import org.ljnpng.algorithm.domain.ListNode;

public class N0148SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = sortList(head.next);
        int val = head.val;
        ListNode tmp = head;
        while (tmp.next != null && val > tmp.next.val) {
            tmp = tmp.next;
        }
        if (!tmp.equals(head)) {
            ListNode p = head.next;
            head.next = tmp.next;
            tmp.next = head;
            head = p;
        }
        return head;
    }
}
