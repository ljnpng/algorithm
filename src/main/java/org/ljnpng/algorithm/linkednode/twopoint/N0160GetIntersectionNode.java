package org.ljnpng.algorithm.linkednode.twopoint;

import org.ljnpng.algorithm.domain.ListNode;

public class N0160GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) { // 就算没有相交，a和b最多走(headA.length + headB.length) 后会同时 = null 不会死循环
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
   }
}
