package org.ljnpng.algorithm.linkednode.reverse;

import org.ljnpng.algorithm.domain.ListNode;

public class N0025ReverseKGroup {

    /**
     * 两次遍历 分组计算
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k ) {
        if (k <= 1) return head;
        ListNode dummy = new ListNode(-1, head), pre = dummy;

        while (pre.next != null) {
            ListNode inx = pre;
            for (int i = 0; i < k; i++) {
                if (inx.next == null) {
                    return dummy.next;
                }
                inx = inx.next;
            }


            ListNode cur = pre.next, next = cur.next;
            for (int i = 0; i < k - 1; i++) {
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;

                next = cur.next;
            }
            pre = cur;

        }
        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k ) {
        if (k <= 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        boolean canReverse = true;
        while (canReverse && pre.next != null) {
            ListNode cur = pre.next, next = cur.next;
            for (int i = 0; i < k - 1; i++) {
                if (next == null) {
                    canReverse = false;
                    break;
                }

                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;

                next = cur.next;
            }
            // 最后不足的部分 重新反转
            if (!canReverse) {
                cur = pre.next;
                next = cur.next;
                while (next != null) {
                    cur.next = next.next;
                    next.next = pre.next;
                    pre.next = next;

                    next = cur.next;
                }
                break;
            }

            pre = cur;

        }
        return dummy.next;
    }


}
