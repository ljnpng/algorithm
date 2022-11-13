package org.ljnpng.algorithm.linkednode.twopoint;

import org.ljnpng.algorithm.domain.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode p1 = list1, p2 = list2, p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;
        return dummy.next;
    }

    /*
    * 利用递归在原链表上进行
    *
    * */
    public ListNode mergeTwoListsWithoutExtraSpace(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoListsWithoutExtraSpace(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsWithoutExtraSpace(list2.next, list1);
            return list2;
        }
    }

}
