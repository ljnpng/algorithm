package org.ljnpng.algorithm.linkednode.twopoint;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.ListNode;
import org.ljnpng.algorithm.util.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeKListsTest {

    @Test
    void mergeKLists() {
        //[[1,4,5],[1,3,4],[2,6]]
        String[] lists = new String[]{"[1,4,5]", "[1,3,4]", "[2,6]"};
        ListNode[] listNode = Arrays.stream(lists)
                .map(Utils::stringToListNode).toArray(value -> new ListNode[lists.length]);
        ListNode result = new MergeKLists().mergeKLists(listNode);

        assertEquals("[1,1,2,3,4,4,5,6]", Utils.listNodeToString(result));

    }
}