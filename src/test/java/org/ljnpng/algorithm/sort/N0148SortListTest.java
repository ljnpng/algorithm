package org.ljnpng.algorithm.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.ListNode;
import org.ljnpng.algorithm.util.Utils;

class N0148SortListTest {


    @Test
    void test_1() {
        ListNode head = Utils.stringToListNode("[4,2,1,3]");
        head = new N0148SortList().sortList(head);
        Assertions.assertEquals(Utils.stringToListNode("[1,2,3,4]"), head);
    }

}