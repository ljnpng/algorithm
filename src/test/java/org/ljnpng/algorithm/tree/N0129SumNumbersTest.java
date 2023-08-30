package org.ljnpng.algorithm.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ljnpng.algorithm.domain.TreeNode;

class N0129SumNumbersTest {

    @Test
    void test_1() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int i = new N0129SumNumbers().sumNumbers(treeNode);
        Assertions.assertEquals(25, i);
    }

    @Test
    void test_0() {
        TreeNode treeNode = new TreeNode(1);
        int i = new N0129SumNumbers().sumNumbers(treeNode);
        Assertions.assertEquals(1, i);
    }

}