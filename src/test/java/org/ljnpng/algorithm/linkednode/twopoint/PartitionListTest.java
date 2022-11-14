package org.ljnpng.algorithm.linkednode.twopoint;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.ListNode;
import org.ljnpng.algorithm.util.Utils;

import static org.junit.jupiter.api.Assertions.*;

class PartitionListTest {

    @Test
    void partition() {
        ListNode listNode = Utils.stringToListNode("[1,4,3,2,5,2]");
        ListNode partition = new PartitionList().partition(listNode, 3);
        assertEquals(Utils.listNodeToString(partition), "[1,2,2,4,3,5]");
    }
}