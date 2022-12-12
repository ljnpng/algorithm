package org.ljnpng.algorithm.linkednode.twopoint;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.ListNode;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class N0142DetectCycleTest {

    private N0142DetectCycle server = new N0142DetectCycle();

    @Test
    void whenEmptyNodeExpectFalse() {
        assertNull(server.detectCycle(new ListNode()));
    }

    @Test
    void whenSingleCycleExpectTrue() {
        ListNode head = new ListNode(1);
        head.next = head;
        assertSame(server.detectCycle(head), head);

    }

    @Test
    void whenSingleNonCycleExpectFalse() {
        ListNode head = new ListNode(1);
        assertNull(server.detectCycle(head));

    }

    @Test
    void whenCycleExpectTrue() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        assertSame(head.next, server.detectCycle(head));

    }

    @Test
    void whenNonCycleExpectFalse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        assertNull(server.detectCycle(head));

    }
}