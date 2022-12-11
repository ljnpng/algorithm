package org.ljnpng.algorithm.linkednode.twopoint;

import org.ljnpng.algorithm.domain.ListNode;

/**
 * 141. 环形链表
 */
public class N0141HasCycle {
    /**
     * 根据快慢指针会在环中相遇来判断
     *
     * @param head 链表
     * @return 是否有环
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
