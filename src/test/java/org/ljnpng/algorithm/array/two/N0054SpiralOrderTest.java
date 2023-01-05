package org.ljnpng.algorithm.array.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class N0054SpiralOrderTest {

    private N0054SpiralOrder service = new N0054SpiralOrder();

    @Test
    void testSpiralOrder() {
        int[][] matrix = new int[][]{{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
        List<Integer> target = service.spiralOrder(matrix);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        Assertions.assertEquals(expect, target);
    }

}