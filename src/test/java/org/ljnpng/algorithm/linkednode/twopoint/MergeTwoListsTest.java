package org.ljnpng.algorithm.linkednode.twopoint;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoListsTest {


    @Test
    void mergeTwoLists() {
        ListNode listNode = new MergeTwoLists().mergeTwoLists(null, null);
        assertNull(listNode);
    }
}
