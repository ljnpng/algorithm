package org.ljnpng.algorithm.linkednode.twopoint;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.ListNode;
import org.ljnpng.algorithm.util.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0019RemoveNthFromEndTest {

    N0019RemoveNthFromEnd cmd = new N0019RemoveNthFromEnd();

    @Test
    void testWhenRemoveSingleListNode() {
        ListNode listNode = Utils.stringToListNode("[1]");
        assertEquals(Utils.stringToListNode("[]"), cmd.removeNthFromEnd(listNode, 1));
    }

    @Test
    void testWhenRemoveFistNode() {
        ListNode listNode = Utils.stringToListNode("[1,2,3,4,5]");
        assertEquals(Utils.stringToListNode("[2,3,4,5]"), cmd.removeNthFromEnd(listNode, 5));
    }

    @Test
    void testWhenRemoveLastNode() {
        ListNode listNode = Utils.stringToListNode("[1,2,3,4,5]");
        assertEquals(Utils.stringToListNode("[1,2,3,4]"), cmd.removeNthFromEnd(listNode, 1));
    }
}