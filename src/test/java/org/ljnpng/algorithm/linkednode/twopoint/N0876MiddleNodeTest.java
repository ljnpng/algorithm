package org.ljnpng.algorithm.linkednode.twopoint;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.ListNode;
import org.ljnpng.algorithm.util.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0876MiddleNodeTest {

    N0876MiddleNode n0876MiddleNode = new N0876MiddleNode();

    @Test
    void testWhenSingleNode() {
        ListNode head = Utils.stringToListNode("[1]");
        assertEquals("[1]", Utils.listNodeToString(n0876MiddleNode.middleNode(head)));
    }

    @Test
    void testWhenTwoNodes() {

        ListNode head = Utils.stringToListNode("[1,2]");
        assertEquals("[2]", Utils.listNodeToString(n0876MiddleNode.middleNode(head)));
    }

    @Test
    void testWhenOddNodes() {

        ListNode head = Utils.stringToListNode("[1,2,3,4,5]");
        assertEquals("[3,4,5]", Utils.listNodeToString(n0876MiddleNode.middleNode(head)));
    }

    @Test
    void testWhenEvenNodes() {

        ListNode head = Utils.stringToListNode("[1,2,3,4,5,6]");
        assertEquals("[4,5,6]", Utils.listNodeToString(n0876MiddleNode.middleNode(head)));
    }

}