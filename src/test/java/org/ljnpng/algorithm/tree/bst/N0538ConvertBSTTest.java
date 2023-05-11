package org.ljnpng.algorithm.tree.bst;

import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0538ConvertBSTTest {

    @Test
    void convertBST() {
        N0538ConvertBST solution = new N0538ConvertBST();
        assertEquals(18, solution.convertBST(new TreeNode(5, new TreeNode(2), new TreeNode(13))).val);

        //more test cases
        assertEquals(0, solution.convertBST(new TreeNode(0)).val);
        assertEquals(3, solution.convertBST(new TreeNode(1, null, new TreeNode(2))).val);
        assertEquals(5, solution.convertBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))).val);
    }
}