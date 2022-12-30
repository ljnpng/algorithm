package org.ljnpng.algorithm.linkednode.twopoint;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.ListNode;
import org.ljnpng.algorithm.util.Utils;

import static org.junit.jupiter.api.Assertions.*;

class N0083DeleteDuplicatesTest {

    private N0083DeleteDuplicates n0083DeleteDuplicates = new N0083DeleteDuplicates();

    @Test
    void testDeleteDuplicates() {
        ListNode src = Utils.stringToListNode("[1,2,2,3]");
        ListNode expect = Utils.stringToListNode("[1,2,3]");

        ListNode node = n0083DeleteDuplicates.deleteDuplicates(src);

        assertEquals(expect, node);
        src = Utils.stringToListNode("[1,1,2,3,3]");
        expect = Utils.stringToListNode("[1,2,3]");

        assertEquals(expect, n0083DeleteDuplicates.deleteDuplicates(src));

    }

}