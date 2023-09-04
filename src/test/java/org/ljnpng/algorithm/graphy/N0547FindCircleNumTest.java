package org.ljnpng.algorithm.graphy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0547FindCircleNumTest {

   @Test
   void test_1() {
       int[][] graph = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
       assertEquals(1, new N0547FindCircleNum().findCircleNum(graph));
   }

}