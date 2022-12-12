package org.ljnpng.algorithm.linkednode.twopoint;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.ListNode;
import org.ljnpng.algorithm.util.Utils;

import static org.junit.jupiter.api.Assertions.*;

class N0160GetIntersectionNodeTest {

    N0160GetIntersectionNode server = new N0160GetIntersectionNode();

    @Test
    void testHasIntersection() {
        ListNode common = Utils.stringToListNode("[1,2,3,4]");
        ListNode headA = new ListNode(7);
        headA.next = common;
        ListNode headB = new ListNode(8);
        headB.next = new ListNode(9);
        headB.next.next = common;

        assertSame(common, server.getIntersectionNode(headA, headB));
    }

    @Test
    void testNonIntersection() {
        ListNode headA = new ListNode(7);
        ListNode headB = new ListNode(8);
        headB.next = new ListNode(9);

        assertNull(server.getIntersectionNode(headA, headB));
    }
}