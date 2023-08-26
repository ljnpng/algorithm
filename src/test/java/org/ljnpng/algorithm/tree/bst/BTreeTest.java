package org.ljnpng.algorithm.tree.bst;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BTreeTest {

    private static BTree bTree;


    @BeforeAll
    static void initBTree() {
        bTree = new BTree(5);
        for (int i = 5; i < 19; i++) {
            bTree.insert(i);
        }
    }

    @Test
    void testInsert() {
        for (int i = 5; i < 10; i++) {
            Assertions.assertTrue(bTree.find(i));
        }
//        bTree.insert(1);
//        bTree.insert(2);
//        bTree.insert(3);
//        bTree.insert(4);
//        bTree.insert(5);
//        bTree.insert(6);
//        bTree.insert(7);
//        bTree.insert(8);
//        bTree.insert(9);
//        bTree.insert(10);
//        bTree.insert(11);
//        bTree.insert(12);
//        bTree.insert(13);
//        bTree.insert(14);
//        bTree.insert(15);
//        bTree.insert(16);
//        bTree.insert(17);
//        bTree.insert(18);
//        bTree.insert(19);
//        bTree.insert(20);
//        bTree.insert(21);
//        bTree.insert(22);
//        bTree.insert(23);
        bTree.insert(41);
        bTree.insert(25);
        bTree.insert(26);
        bTree.insert(27);
        bTree.insert(28);
        bTree.insert(29);
        bTree.insert(30);
        bTree.insert(31);
        bTree.insert(32);
        bTree.insert(33);
        bTree.insert(34);
        bTree.insert(35);
        bTree.insert(36);
        bTree.insert(37);
        bTree.insert(38);
        bTree.insert(39);
        bTree.insert(40);
        bTree.insert(41);
        bTree.insert(42);
        bTree.insert(43);
        bTree.insert(44);
        bTree.insert(45);
        bTree.insert(46);
        bTree.insert(47);
        bTree.insert(48);
        bTree.insert(49);
        bTree.insert(50);
        bTree.insert(51);
        bTree.insert(52);
        bTree.insert(53);
        bTree.insert(54);
        bTree.insert(55);
        bTree.insert(56);
        bTree.insert(57);
        bTree.insert(58);
        bTree.insert(59);
        bTree.insert(60);
        bTree.insert(61);
        bTree.insert(62);
        bTree.insert(63);
        bTree.insert(64);
        bTree.insert(65);
        bTree.insert(66);
        bTree.insert(67);
        bTree.insert(68);
        bTree.insert(69);
        bTree.insert(70);
    }

}