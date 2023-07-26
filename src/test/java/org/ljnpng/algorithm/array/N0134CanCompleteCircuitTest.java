package org.ljnpng.algorithm.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N0134CanCompleteCircuitTest {

    @Test
    void test_1() {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        N0134CanCompleteCircuit solution = new N0134CanCompleteCircuit();
        int result = solution.canCompleteCircuit(gas, cost);
        assertEquals(3, result);
    }

    @Test
    void test_2() {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};

        N0134CanCompleteCircuit solution = new N0134CanCompleteCircuit();
        int result = solution.canCompleteCircuit(gas, cost);
        assertEquals(-1, result);
    }

    @Test
    void test_3() {
        int[] gas = {5,1,2,3,4};
        int[] cost = {4,4,1,5,1};

        N0134CanCompleteCircuit solution = new N0134CanCompleteCircuit();
        int result = solution.canCompleteCircuit(gas, cost);
        assertEquals(4, result);
    }

}