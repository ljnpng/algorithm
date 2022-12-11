package org.ljnpng.algorithm.linkednode.twopoint;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class N0141HasCycleTest {

    N0141HasCycle n0141HasCycle = new N0141HasCycle();

    @Test
    void whenEmptyNodeExpectFalse() {
        assertFalse(n0141HasCycle.hasCycle(new ListNode()));
    }

    @Test
    void whenSingleCycleExpectTrue() {
        ListNode head = new ListNode(1);
        head.next = head;
        assertTrue(n0141HasCycle.hasCycle(head));

    }

    @Test
    void whenSingleNonCycleExpectFalse() {
        ListNode head = new ListNode(1);
        assertFalse(n0141HasCycle.hasCycle(head));

    }

    @Test
    void whenCycleExpectTrue() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        assertTrue(n0141HasCycle.hasCycle(head));

    }

    @Test
    void whenNonCycleExpectFalse() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        assertFalse(n0141HasCycle.hasCycle(head));

    }

}