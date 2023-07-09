package org.ljnpng.algorithm.tree.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N0095GenerateTreesTest {

    @Test
    void numTrees() {
        assertEquals(5, new N0095GenerateTrees().generateTrees(3).size());
    }

}