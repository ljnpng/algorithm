package org.ljnpng.algorithm.tree;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.TreeNode;
import org.ljnpng.algorithm.tree.bst.N0230KthSmallest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0230KthSmallestTest {

    @Test
    void test() {
        int i = new N0230KthSmallest().kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 1);
        assertEquals(1, i);
        i = new N0230KthSmallest().kthSmallest(null, 0);
        assertEquals(0, i);
    }

}