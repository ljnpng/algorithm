package org.ljnpng.algorithm.tree.bst;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class N0098IsValidBSTTest {

    @Test
    void isValidBST() {
        new N0098IsValidBST().isValidBST(null);
        assertTrue(new N0098IsValidBST().isValidBST(null));

        // more complicate test cases
        assertFalse(new N0098IsValidBST().isValidBST(new TreeNode(1, new TreeNode(1), null)));

        assertTrue(new N0098IsValidBST().isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));

        assertFalse(new N0098IsValidBST().isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))));
    }
}