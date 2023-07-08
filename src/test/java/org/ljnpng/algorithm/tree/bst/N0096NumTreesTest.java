package org.ljnpng.algorithm.tree.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0096NumTreesTest {

    @Test
    public void test() {
        N0096NumTrees n0096NumTrees = new N0096NumTrees();
        assertEquals(0, n0096NumTrees.numTrees(0));
        assertEquals(1, n0096NumTrees.numTrees(1));
        assertEquals(2, n0096NumTrees.numTrees(2));
        assertEquals(5, n0096NumTrees.numTrees(3));
        assertEquals(14, n0096NumTrees.numTrees(4));
        assertEquals(28 + 10 + 4, n0096NumTrees.numTrees(5));
    }
}