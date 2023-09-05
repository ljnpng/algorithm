package org.ljnpng.algorithm.graphy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0909SnakesAndLaddersTest {

   @Test
   void test_0() {
       int[] ints = new N0909SnakesAndLadders().numToPos(7, 6);
       Assertions.assertEquals(4, ints[0]);
       Assertions.assertEquals(5, ints[1]);

       ints = new N0909SnakesAndLadders().numToPos(29, 6);
       Assertions.assertEquals(1, ints[0]);
       Assertions.assertEquals(4, ints[1]);
   }

}