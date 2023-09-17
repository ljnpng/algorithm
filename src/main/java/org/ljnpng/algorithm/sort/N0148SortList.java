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

    public ListNode sortList2(ListNode head) {
        return sortList2(head, null);
    }

    public ListNode sortList2(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode right = sortList2(slow, tail);
        ListNode left = sortList2(head, slow);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tmp.next = left;
                left = left.next;
            } else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }

        tmp.next = left != null ? left : right;
        return dummy.next;
    }
}
