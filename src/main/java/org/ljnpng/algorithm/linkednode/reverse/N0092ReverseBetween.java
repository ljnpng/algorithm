package org.ljnpng.algorithm.linkednode.reverse;

import org.ljnpng.algorithm.domain.ListNode;

public class N0092ReverseBetween {
    /**
     * 先截取 再拼接
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode leftNode = pre.next, rightNode = leftNode;
        pre.next = null;

        for (int i = 0; i < right - left; i++) {
            rightNode = rightNode.next;
        }

        ListNode succ = rightNode.next;
        rightNode.next = null;

        ListNode newNode = reverse(leftNode);

        pre.next = newNode;
        leftNode.next = succ;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 一次遍历
     * @param head 头节点
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next, next = cur.next;
        for (int i = 0; i < right - left; i++) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;

            next = cur.next;
        }

        return dummy.next;

    }

}
