package org.ljnpng.algorithm.linkednode.reverse;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.ListNode;
import org.ljnpng.algorithm.util.Utils;

import static org.junit.jupiter.api.Assertions.*;

class N0206ReverseListTest {

    N0206ReverseList n0206ReverseList = new N0206ReverseList();

    @Test
    void testEmptyListNode() {
        ListNode empty = Utils.stringToListNode("[]");

        assertEquals(empty, n0206ReverseList.reverseList(empty));
        assertEquals(empty, n0206ReverseList.reverseList2(empty));

    }

    @Test
    void testSingleListNode() {
        ListNode singleton = Utils.stringToListNode("[1]");

        assertEquals(singleton, n0206ReverseList.reverseList(singleton));
        assertEquals(singleton, n0206ReverseList.reverseList2(singleton));
    }

    @Test
    void testMultipleListNode() {
        ListNode multiple = Utils.stringToListNode("[1,2,3,4]");
        ListNode reverse = Utils.stringToListNode("[4,3,2,1]");

        assertEquals(reverse, n0206ReverseList.reverseList(multiple));

        multiple = Utils.stringToListNode("[1,2,3,4]");
        assertEquals(reverse, n0206ReverseList.reverseList2(multiple));
    }

}