package org.ljnpng.algorithm.linkednode.twopoint;

import org.ljnpng.algorithm.domain.ListNode;

/**
 * 删除排序链表中的重复元素
 * 相似题目，删除有序数组中的重复项
 *
 * @see org.ljnpng.algorithm.array.N0026RemoveDuplicates
 * @see org.ljnpng.algorithm.array.N0027RemoveElement
 */
public class N0083DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }

        slow.next = null;
        return head;
    }
}
